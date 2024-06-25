package com.javweb.spring_boot_non_jwt.controllerAdvices;

import com.javweb.spring_boot_non_jwt.models.ErroResponseDTO;
import com.javweb.spring_boot_non_jwt.customException.FiledRequiredException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class controllerAdvisor extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ArithmeticException.class) // loai ex can xwet
    public ResponseEntity<Object> handleArithmeticException(ArithmeticException ex, WebRequest request) {
        ErroResponseDTO erroResponseDTO = new ErroResponseDTO();
        erroResponseDTO.setError(ex.getMessage());
        List<String> details = new ArrayList<>();
        details.add("So nguyen khong duoc chi cho 0");
        erroResponseDTO.setDetail(details);
        return  new ResponseEntity<>(erroResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR); // trang thai
    }


    @ExceptionHandler(FiledRequiredException.class) // loai ex can xwet
    public ResponseEntity<Object> handleFiledRequiredException(FiledRequiredException ex, WebRequest request) {
        ErroResponseDTO erroResponseDTO = new ErroResponseDTO();
        erroResponseDTO.setError(ex.getMessage());
        List<String> details = new ArrayList<>();
        details.add("Co truong du lieu bi null");
        erroResponseDTO.setDetail(details);
        return  new ResponseEntity<>(erroResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR); // trang thai
    }
}
