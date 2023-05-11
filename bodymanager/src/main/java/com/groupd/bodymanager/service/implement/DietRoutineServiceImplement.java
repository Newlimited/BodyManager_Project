package com.groupd.bodymanager.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.groupd.bodymanager.common.CustomResponse;
import com.groupd.bodymanager.dto.request.dietRoutine.PatchDietRoutineRequestDto;
import com.groupd.bodymanager.dto.request.dietRoutine.PostDietRoutineRequestDto;
import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.dto.response.dietRoutine.GetDietRoutineResponseDto;
import com.groupd.bodymanager.entity.MenuEntity;
import com.groupd.bodymanager.repository.DietDetailRepository;
import com.groupd.bodymanager.repository.DietRepository;
import com.groupd.bodymanager.repository.MenuRepository;
import com.groupd.bodymanager.repository.UserRepository;
import com.groupd.bodymanager.service.DietRoutineService;

@Service
public class DietRoutineServiceImplement implements DietRoutineService{

    

    private MenuRepository menuRepository;
    private DietRepository dietRepository;
    private DietDetailRepository dietDetailRepository;
    private UserRepository userRepository;

    @Autowired
    DietRoutineServiceImplement(
        MenuRepository menuRepository,UserRepository userRepository,DietRepository dietRepository,DietDetailRepository dietDetailRepository
    ) {
        this.menuRepository = menuRepository;
        this.userRepository = userRepository;
        this.dietRepository = dietRepository;
        this.dietDetailRepository = dietDetailRepository;
    }

    @Override
    public ResponseEntity<ResponseDto> postDietRoutine(PostDietRoutineRequestDto dto) {
        ResponseDto body = null;
        String menuCode = dto.getMenuCode();
        int userCode = dto.getUserCode();

        try {
            if(menuCode == null ) return CustomResponse.vaildationFaild();
            //*존재하지 않는 메뉴코드 반환 */
            boolean existedByMenuCode = menuRepository.existedByMenuCode(menuCode);


            if(!existedByMenuCode) {
                ResponseDto errorBody = new ResponseDto("NMC", "Non-Existent Menu Code");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorBody);
            }

            MenuEntity entity = new MenuEntity(dto);
            

            
            
        } catch (Exception exceptione) {
            exceptione.printStackTrace();
            //*데이터베이스 오류 */
            return CustomResponse.databaseError();
        }

        //*성공 반환 */

        return CustomResponse.successs();

    }

    @Override
    public ResponseEntity<ResponseDto> patchDietRoutine(PatchDietRoutineRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patchDietRoutine'");
    }

    @Override
    public ResponseEntity<? super GetDietRoutineResponseDto> getDietRoutine() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDietRoutine'");
    }

    
    
}
