package com.groupd.bodymanager.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.groupd.bodymanager.common.CustomResponse;
import com.groupd.bodymanager.dto.request.dietRoutine.PatchDietRoutineRequestDto;
import com.groupd.bodymanager.dto.request.dietRoutine.PostDietRoutineRequestDto;
import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.dto.response.dietRoutine.GetDietRoutineResponseDto;
import com.groupd.bodymanager.entity.MenuDetailEntity;
import com.groupd.bodymanager.entity.MenuEntity;
import com.groupd.bodymanager.entity.UserEntity;
import com.groupd.bodymanager.repository.MenuDetailRepository;
import com.groupd.bodymanager.repository.MenuRepository;
import com.groupd.bodymanager.repository.UserRepository;
import com.groupd.bodymanager.service.DietRoutineService;

@Service
public class DietRoutineServiceImplement implements DietRoutineService{
    
    private MenuRepository menuRepository;
    private MenuDetailRepository menuDetailRepository;
    private UserRepository userRepository;
    @Autowired
    DietRoutineServiceImplement(
        MenuRepository menuRepository,UserRepository userRepository, MenuDetailRepository menuDetailRepository;
    ) {
        this.menuRepository = menuRepository;
        this.userRepository = userRepository;
        this.menuDetailRepository = dietRepository;

    }
    @Override
    public ResponseEntity<ResponseDto> postDietRoutine(PostDietRoutineRequestDto dto) {
        ResponseDto body = null;
        String menuCode = dto.getMenuCode();
        try {
            if(menuCode == null ) return CustomResponse.validationFaild();
            //*존재하지 않는 메뉴코드 반환 */
            boolean existedByMenuCode = menuRepository.existedByMenuCode(menuCode);
            if(!existedByMenuCode) {
                ResponseDto errorBody = new ResponseDto("NMC", "Non-Existent Menu Code");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorBody);
            }
            MenuEntity menuEntity = new MenuEntity(dto);
            menuRepository.save(menuEntity);
            
        } catch (Exception exceptione) {
            exceptione.printStackTrace();
            //*데이터베이스 오류 */
            return CustomResponse.databaseError();
        }
        //*성공 반환 */
        return CustomResponse.successs();
    }
    
    @Override
    public ResponseEntity<? super GetDietRoutineResponseDto> getDietRoutine(PostDietRoutineRequestDto dto) {
        GetDietRoutineResponseDto body = null;
        String menuCode = dto.getMenuCode();
        int userCode = dto.getUserCode();

        try {
            MenuEntity menuEntity = menuRepository.findByUserCode(userCode);
             //*존재하지 않는 메뉴코드 반환 */
            if(menuEntity == null ) return CustomResponse.notExistUserCode();

            DietEntity dietEntities = dietRepository.findByMenuCodeAndOUserCode(menuCode,userCode);
            List<DietDetailEntity> dietDetailEntities = dietDetailRepository.find


            
            for(DietEntity dietEntity : dietEntities) {
                int dietNumber = dietEntity.getDietNumber();
                
                DietDetailEntity dietDetailEntities = dietDetailRepository.findByDietNumber(dietNumber);
                
            }


            
            

    



            
        } catch (Exception exceptione) {
            exceptione.printStackTrace();
            //*데이터베이스 오류 */
            return CustomResponse.databaseError();
        }

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDietRoutine'");
    }

    @Override
    public ResponseEntity<ResponseDto> patchDietRoutine(PatchDietRoutineRequestDto dto) {


        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patchDietRoutine'");
    }

    
    
}
