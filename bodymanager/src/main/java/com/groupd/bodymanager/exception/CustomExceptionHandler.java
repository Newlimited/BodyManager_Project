package com.groupd.bodymanager.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.groupd.bodymanager.common.CustomResponse;
import com.groupd.bodymanager.dto.response.ResponseDto;

@RestController
public class CustomExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseDto> handlerHttpMessageNotReadableException(
            HttpMessageNotReadableException exception) {
        // 결과가 ResponseEntity로 반환됨 컨트롤러이기 때문에 ... 그리고 처리하고자 하는 메세지를 매게변수로 받아온다.
        return CustomResponse.validationFaild();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> handlerMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {

        return CustomResponse.validationFaild();
    }
}
