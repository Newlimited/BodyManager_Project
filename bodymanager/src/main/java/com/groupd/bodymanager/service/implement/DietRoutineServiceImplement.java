package com.groupd.bodymanager.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.groupd.bodymanager.dto.request.dietRoutine.PatchDietRoutineRequestDto;
import com.groupd.bodymanager.dto.request.dietRoutine.PostDietRoutineRequestDto;
import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.dto.response.dietRoutine.GetDietRoutineResponseDto;
import com.groupd.bodymanager.repository.MenuRepository;
import com.groupd.bodymanager.service.DietRoutineService;

@Service
public class DietRoutineServiceImplement implements DietRoutineService{

    private MenuRepository menuRepository;

    @Override
    public ResponseEntity<ResponseDto> postDietRoutine(PostDietRoutineRequestDto dto) {
        ResponseDto body = null;
        String menuCode = dto.getMenuCode();

        try {
            //*존재하지 않는 메뉴코드 반환 */
            boolean existedByMenuCode = menuRepository.ex
            
        } catch (Exception exceptione) {
            exceptione.printStackTrace();
        }


        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postDietRoutine'");
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
