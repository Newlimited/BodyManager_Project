package com.groupd.bodymanager.service.implement;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.groupd.bodymanager.common.CustomResponse;
import com.groupd.bodymanager.dto.request.user.DeleteUserRequestDto;
import com.groupd.bodymanager.dto.request.user.PatchUserRequestDto;
import com.groupd.bodymanager.dto.request.user.PostManagerRequestDto;
import com.groupd.bodymanager.dto.request.user.SignInRequestDto;
import com.groupd.bodymanager.dto.request.user.SignUpRequestDto;
import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.dto.response.user.GetAuthResponseDto;
import com.groupd.bodymanager.dto.response.user.GetUserResponseDto;
import com.groupd.bodymanager.entity.BoardEntity;
import com.groupd.bodymanager.entity.BodyInfoEntity;
import com.groupd.bodymanager.entity.ManagerEntity;
import com.groupd.bodymanager.entity.MenuEntity;
import com.groupd.bodymanager.entity.MileageEntity;
import com.groupd.bodymanager.entity.UserEntity;
import com.groupd.bodymanager.entity.UserMenuSelect;
import com.groupd.bodymanager.provider.JwtProvider;
import com.groupd.bodymanager.repository.BoardRepository;
import com.groupd.bodymanager.repository.BodyInfoRepository;
import com.groupd.bodymanager.repository.ManagerRepository;
import com.groupd.bodymanager.repository.MenuDetailRepository;
import com.groupd.bodymanager.repository.MileageRepository;
import com.groupd.bodymanager.repository.UserMenuSelectRepository;
import com.groupd.bodymanager.repository.UserRepository;
import com.groupd.bodymanager.service.UserService;

@Service
public class UserServiceImplement implements UserService {
    private UserRepository userRepository;
    private ManagerRepository managerRepository;
    private MileageRepository mileageRepository;
    private JwtProvider jwtProvider;
    private PasswordEncoder passwordEncoder;
    private BodyInfoRepository bodyInfoRepository;
    private UserMenuSelectRepository userMenuSelectRepository;

    @Autowired
    public UserServiceImplement(
            UserRepository userRepository,
            JwtProvider jwtProvider, ManagerRepository managerRepository, MileageRepository mileageRepository, 
            UserMenuSelectRepository userMenuSelectRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.jwtProvider = jwtProvider;
        this.managerRepository = managerRepository;
        this.mileageRepository = mileageRepository;
        this.userMenuSelectRepository = userMenuSelectRepository;
    }

    // 회원가입
    @Override
    public ResponseEntity<? super GetAuthResponseDto> signUp(SignUpRequestDto dto) {
        GetAuthResponseDto body = null;
        String userEmail = dto.getUserEmail();
        String userPassword = dto.getUserPassword();
        String userNickname = dto.getUserNickname();
        String userPhoneNumber = dto.getUserPhoneNumber();
        String userAddress = dto.getUserAddress();
        String userGender = dto.getUserGender();
        int userAge = dto.getUserAge();

        try {
            // 존재하는 유저 이메일
            boolean existedUserEmail = userRepository.existsByUserEmail(userEmail);
            if (existedUserEmail)
                return CustomResponse.existUserEmail();

            // 존재하는 유저 닉네임
            boolean existedUserNickname = userRepository.existsByUserNickname(userNickname);
            if (existedUserNickname)
                return CustomResponse.existUserNickname();

            // 존재하는 유저 휴대전화 번호
            boolean existedUserPhoneNumber = userRepository.existsByUserPhoneNumber(userPhoneNumber);
            if (existedUserPhoneNumber)
                return CustomResponse.existUserPhoneNumber();

            String encodedPassword = passwordEncoder.encode(userPassword); // 유저 계정 생성 및 암호화 작업
            dto.setUserPassword(encodedPassword);

            UserEntity userEntity = new UserEntity(dto);
            userRepository.save(userEntity);
            System.out.println(userEntity.toString());
            int userCode = userEntity.getUserCode();

            MileageEntity mileageEntity = new MileageEntity();
            mileageEntity.setUserCode(userCode);
            mileageEntity.setAttendanceToday(false);
            mileageEntity.setAttendanceDate(null);
            mileageEntity.setAttendanceMileage(0);
            mileageRepository.save(mileageEntity);

            body = new GetAuthResponseDto(userCode);

        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    // 로그인
    @Override
    public ResponseEntity<? super GetAuthResponseDto> signIn(SignInRequestDto dto) {
        GetAuthResponseDto body = null;

        String userEmail = dto.getUserEmail();
        String userPassword = dto.getUserPassword();

        try {
            // 로그인 실패 (이메일 x)
            UserEntity userEntity = userRepository.findByUserEmail(userEmail);
            if (userEntity == null)
                return CustomResponse.signInFailed();

            // 로그인 실패 (패스워드 x)
            String encordedPassword = userEntity.getUserPassword();
            boolean equaledPassword = passwordEncoder.matches(userPassword, encordedPassword);
            ;
            if (!equaledPassword)
                return CustomResponse.signInFailed();

            String jwt = jwtProvider.create(userEmail);
            int userCode = userEntity.getUserCode();
            body = new GetAuthResponseDto(jwt, userCode);
        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    
    // 사용자 조회
    @Override
    public ResponseEntity<? super GetUserResponseDto> getUser(Integer userCode) {
        GetUserResponseDto body = null;

        try {

            if (userCode == null) {
                return CustomResponse.validationFaild();
            }
            // todo 존재하지 않는 회원코드
            // 유저코드 조회
            UserEntity userEntity = userRepository.findByUserCode(userCode);
            // 존재하지 않는 유저 코드 조회시
            if (userEntity == null) {
                return CustomResponse.notExistUserCode();
            }

            body = new GetUserResponseDto(userEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }

        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @Override
    public ResponseEntity<ResponseDto> patchUser(String email, PatchUserRequestDto dto) {

        ResponseDto responseBody = null;
        UserEntity userEntity = userRepository.findByUserEmail(email);
        String userPassword = userEntity.getUserPassword();
        String userNewPassword = dto.getUserNewPassword();
        String userNewPasswordCheck = dto.getUserNewPasswordCheck();
        String userNickname = dto.getUserNickname();
        String userPhoneNumber = dto.getUserPhoneNumber();
        String userAddress = dto.getUserAddress();
        String userGender = dto.getUserGender();
        Integer userAge = dto.getUserAge();

        Pattern phoneNumberPattern = Pattern.compile("^\\d{2,3}-\\d{3,4}-\\d{4}$");

        try {
            boolean isRightPassword = passwordEncoder.matches(dto.getUserPassword(), userPassword);
            if (!isRightPassword) { // TODO 기존 비밀번호 불일치
                return CustomResponse.noPermission();
            }

            boolean changePassword = !userNewPassword.isEmpty();
            if (changePassword) { // TODO 암호변경 여부
                int passwordSize = userNewPassword.length();
                boolean isRightLength = passwordSize >= 8;
                if (!isRightLength) {
                    return CustomResponse.notMatchedForm();
                }
                boolean isMatchedPassword = userNewPassword.equals(userNewPasswordCheck);
                if (!isMatchedPassword) { // TODO 새로운 비밀번호와 비밀번호 확인간의 불일치
                    return CustomResponse.notMatchedPassword();
                }
                userPassword = passwordEncoder.encode(userNewPassword);
                userEntity.setUserPassword(userPassword); // 비밀번호 변경
                // 나머지는 변경된 사항 저장
            }
            

            boolean isExistNickname = userRepository.existsByUserNickname(userNickname);
            boolean isChangedNickname = userEntity.getUserNickname().equals(userNickname);
            if (!isChangedNickname) {
                if (isExistNickname) { // TODO 존재하는 유저 닉네임
                    return CustomResponse.existUserNickname();
                }
            }
            boolean isChangedPhoneNumber = userEntity.getUserPhoneNumber().equals(userPhoneNumber);
            boolean isExistPhoneNumber = userRepository.existsByUserPhoneNumber(userPhoneNumber);
            if (!isChangedPhoneNumber) {
                if (isExistPhoneNumber) { // TODO 존재하는 유저 휴대전화 번호
                    return CustomResponse.existUserPhoneNumber();
                }
            }
            boolean changeNickname = !userNickname.isEmpty();
            if (!changeNickname) {
                userEntity.setUserNickname(userNickname); // 닉네임 변경
            } 
            boolean changePhoneNumber = !userPhoneNumber.isEmpty(); // 값이 있냐? 있으면 T
            if (changePhoneNumber) {// TODO 폰번호 변경 여부
                Matcher matchPatternPhoneNumber = phoneNumberPattern.matcher(userPhoneNumber);
                boolean isMatchedPattern = matchPatternPhoneNumber.matches();
                if (!isMatchedPattern) {// 패턴 맞냐?
                    return CustomResponse.notMatchedForm();
                }
                userEntity.setUserPhoneNumber(userPhoneNumber);        // 휴대전화번호 변경 // 패턴 맞으면
            }
            if(userAddress != null){
            userEntity.setUserAddress(userAddress);
            }
            if(userGender != null){
            userEntity.setUserGender(userGender);
            }
            if(userAge != null){
            userEntity.setUserAge(userAge);
        }
        

            userRepository.save(userEntity); // 변경된 유저 정보 저장

        } catch (Exception exception) {
            exception.printStackTrace();
            responseBody = new ResponseDto("DE", "DatabaseError");
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(responseBody);
        }

        return CustomResponse.successs();
    }

    @Override
    public ResponseEntity<ResponseDto> deleteUser(String userEmail, DeleteUserRequestDto dto) {

        String userEmailCheck = dto.getUserEmailCheck();
        String userPassword = dto.getUserPassword();

        try {
            // todo 로그인 상태에서 로그인된 이메일을 어떻게 가져오는지
            boolean matchId = userEmail.equals(userEmailCheck);
            if (!matchId)
                return CustomResponse.signInFailed();

            // 로그인 실패 (패스워드 x)
            UserEntity userEntity = userRepository.findByUserEmail(userEmailCheck);
            String encordedPassword = userEntity.getUserPassword();
            boolean equaledPassword = passwordEncoder.matches(userPassword, encordedPassword);

            if (!equaledPassword)
                return CustomResponse.signInFailed();
            // body = new GetAuthResponseDto(jwt, userCode);
            // 회원 메일이 관리자목록에 있을 경우 관리자목록에서도 삭제
            ManagerEntity managerEntity = managerRepository.findByManagerEmail(userEmail);
            if(managerEntity !=null){
                managerRepository.delete(managerEntity);
            }
            userRepository.delete(userEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }
        return CustomResponse.successs();
    }
}
