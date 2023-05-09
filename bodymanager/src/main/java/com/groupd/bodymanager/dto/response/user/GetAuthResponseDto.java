package com.groupd.bodymanager.dto.response.user;



import com.groupd.bodymanager.dto.response.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
<<<<<<< HEAD

=======
>>>>>>> d83a2670bbe1c12246507be600697ad0b7f9d70e
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAuthResponseDto extends ResponseDto {
     
    private int userCode;
    private String token;
    private int expirationDate;  

<<<<<<< HEAD

=======
>>>>>>> d83a2670bbe1c12246507be600697ad0b7f9d70e
    public GetAuthResponseDto(int userCode){ //회원가입
        super("SU", "Sucess");
        this.userCode = userCode;
    }
    public GetAuthResponseDto(String token, int userCode){ //로그인
        super("SU", "Sucess");
        this.token = token;
        this.expirationDate = 3600;
    }

}