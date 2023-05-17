package com.groupd.bodymanager.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.groupd.bodymanager.common.CustomResponse;
import com.groupd.bodymanager.dto.request.menu.MenuRequestDto;
import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.dto.response.menu.GetMenuDetailListResponseDto;
import com.groupd.bodymanager.dto.response.menu.GetMenuResponseDto;
import com.groupd.bodymanager.entity.MenuDetailEntity;
import com.groupd.bodymanager.entity.MenuEntity;
import com.groupd.bodymanager.entity.UserEntity;
import com.groupd.bodymanager.entity.UserMenuSelect;
import com.groupd.bodymanager.entity.resultSet.MenuListResultSet;
import com.groupd.bodymanager.repository.MenuDetailRepository;
import com.groupd.bodymanager.repository.MenuRepository;
import com.groupd.bodymanager.repository.UserMenuSelectRepository;
import com.groupd.bodymanager.repository.UserRepository;
import com.groupd.bodymanager.service.MenuService;

@Service
public class MenuServiceImplement implements MenuService {
    private UserRepository userRepository;
    private MenuRepository menuRepository;
    private MenuDetailRepository menuDetailRepository;
    private UserMenuSelectRepository userMenuSelectRepository;

    @Autowired
    MenuServiceImplement(
        MenuRepository menuRepository, UserRepository userRepository, MenuDetailRepository menuDetailRepository,UserMenuSelectRepository userMenuSelectRepository){
        this.menuRepository = menuRepository;
        this.userRepository = userRepository;
        this.menuDetailRepository = menuDetailRepository;
        this.userMenuSelectRepository = userMenuSelectRepository;

    }

    @Override
    public ResponseEntity<ResponseDto> postMenuCodeAndUserCode(MenuRequestDto dto) {
        GetMenuDetailListResponseDto body = null;
        String menuCode = dto.getMenuCode();
        int userCode = dto.getUserCode();
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
            
            // *Response 데이터를 레포지토리에 저장 */
            UserMenuSelect userMenuSelect = new UserMenuSelect(menuCode, userCode);
            userMenuSelectRepository.save(userMenuSelect);
            // MenuEntity menuEntity = new MenuEntity(menuCode);
            // menuRepository.save(menuEntity);
            
            
        } catch (Exception exceptione) {
            exceptione.printStackTrace();
            // *데이터베이스 오류 */
            return CustomResponse.databaseError();
        }
        // *성공 반환 */
        return CustomResponse.successs();
    }


    @Override //*메뉴엔티티를 반환,메뉴네임 */
    public ResponseEntity<? super GetMenuResponseDto> getMenu(MenuRequestDto dto) {
        GetMenuResponseDto body = null;
        String menuCode = dto.getMenuCode();
        int userCode = dto.getUserCode();
        
        try {
            UserMenuSelect userMenuSelect = userMenuSelectRepository.findByUserCode(userCode);
            // **/
            if (userMenuSelect == null)
                return CustomResponse.notExistUserCode();

            MenuEntity menuEntity = menuRepository.findByMenuCode(menuCode);
            body = new GetMenuResponseDto(menuEntity, userMenuSelect);

        } catch (Exception exceptione) {
            exceptione.printStackTrace();
            // *데이터베이스 오류 */
            return CustomResponse.databaseError();
        }

        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    
    @Override //메뉴코드에 맞는 식단 조회
    public ResponseEntity<? super GetMenuDetailListResponseDto> getMenuDetailList() {
        GetMenuDetailListResponseDto body = null;
        
        try {
            List<MenuListResultSet> resultSet = menuDetailRepository.getMenuDetailList();
            body = new GetMenuDetailListResponseDto(resultSet);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
    




    @Override // 유저의 식단 코드 변경
    public ResponseEntity<ResponseDto> patchMenuCode(MenuRequestDto dto) {
        int userCode = dto.getUserCode();
        String menuCode = dto.getMenuCode();

        try {
            UserMenuSelect userMenuSelect = userMenuSelectRepository.findByUserCode(userCode);
            if(userMenuSelect == null) return CustomResponse.notExistUserCode();
            userMenuSelect.setMenuCode(menuCode);
            

            userMenuSelectRepository.save(userMenuSelect);
        } catch (Exception exception) {
            exception.printStackTrace();
            CustomResponse.databaseError();
        }
            return CustomResponse.successs();
    }


}
