package com.groupd.bodymanager.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.groupd.bodymanager.common.CustomResponse;
import com.groupd.bodymanager.dto.request.menu.PatchMenuRequestDto;
import com.groupd.bodymanager.dto.request.menu.PostMenuRequestDto;
import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.dto.response.menu.GetMenuDetailListResponseDto;
import com.groupd.bodymanager.dto.response.menu.GetMenuResponseDto;
import com.groupd.bodymanager.entity.MenuDetailEntity;
import com.groupd.bodymanager.entity.MenuEntity;
import com.groupd.bodymanager.entity.UserEntity;
<<<<<<< HEAD
import com.groupd.bodymanager.entity.UserMenuSelect;
=======
import com.groupd.bodymanager.entity.resultSet.MenuListResultSet;
>>>>>>> 0cd8678ce329d252ecbfbebf662855bbc34a9417
import com.groupd.bodymanager.repository.MenuDetailRepository;
import com.groupd.bodymanager.repository.MenuRepository;
import com.groupd.bodymanager.repository.UserRepository;
import com.groupd.bodymanager.service.MenuService;

@Service
public class MenuServiceImplement implements MenuService {

    private MenuRepository menuRepository;
    private MenuDetailRepository menuDetailRepository;
    private UserRepository userRepository;

    @Autowired
    MenuServiceImplement(
            MenuRepository menuRepository, UserRepository userRepository, MenuDetailRepository menuDetailRepository) {
        this.menuRepository = menuRepository;
        this.userRepository = userRepository;
        this.menuDetailRepository = menuDetailRepository;

    }

    @Override
    public ResponseEntity<? super GetMenuDetailListResponseDto> postDietRoutine(PostMenuRequestDto dto) {
        GetMenuDetailListResponseDto body = null;
        String menuCode = dto.getMenuCode();
        try {
            // 필수 값 입력
            if (menuCode == null)
                return CustomResponse.validationFaild();

            // *존재하지 않는 메뉴코드 반환 */
            boolean existedByMenuCode = menuRepository.existsByMenuCode(menuCode);
            if (!existedByMenuCode) {
                ResponseDto errorBody = new ResponseDto("NMC", "Non-Existent Menu Code");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorBody);
            }
            MenuEntity menuEntity = new MenuEntity(menuCode);
            menuRepository.save(menuEntity);
<<<<<<< HEAD
           } catch (Exception exceptione) {
=======
            
            
        } catch (Exception exceptione) {
>>>>>>> 0cd8678ce329d252ecbfbebf662855bbc34a9417
            exceptione.printStackTrace();
            // *데이터베이스 오류 */
            return CustomResponse.databaseError();
        }
        // *성공 반환 */
        return CustomResponse.successs();
    }

<<<<<<< HEAD
=======
    
    
    
        }
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
    
>>>>>>> 0cd8678ce329d252ecbfbebf662855bbc34a9417
    @Override
    public ResponseEntity<? super GetMenuResponseDto> getMenuDetail(PostMenuRequestDto dto) {
        GetMenuResponseDto body = null;
        String menuCode = dto.getMenuCode();
        int userCode = dto.getUserCode();
        

        try {
<<<<<<< HEAD
            UserEntity userEntity = userRepository.findByUserCode(userCode);
            // *존재하지 않는 메뉴코드 반환 */
            if (userEntity == null)
                return CustomResponse.notExistUserCode();

=======
            MenuEntity menuEntity = menuRepository.findByUserCode(userCode);
             //*존재하지 않는 메뉴코드 반환 */
            if(menuEntity == null ) return CustomResponse.notExistUserCode();
            
>>>>>>> 0cd8678ce329d252ecbfbebf662855bbc34a9417
        } catch (Exception exceptione) {
            exceptione.printStackTrace();
            // *데이터베이스 오류 */
            return CustomResponse.databaseError();
        }

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDietRoutine'");
    }



    @Override // 유저의 식단 코드 변경
    public ResponseEntity<ResponseDto> patchDietRoutine(PatchMenuRequestDto dto) {

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patchDietRoutine'");
    }
  

}
