package com.ivanovsergei.spring.rest.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeGlobalExceptionHandler {

//    глобальная обработка исключений
    @ExceptionHandler//ловим исключение по неверному ид работника (отсутствующий ид в базе)
    public ResponseEntity<EmployeeIncorrectData> handleException(NoSuchEmployeeException exception){
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exception.getMessage());//берем сообщение из параметра конструктора исключения
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler//ловим исключение по вводу символов в ид работника
    public ResponseEntity<EmployeeIncorrectData> handleException(Exception exception){
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exception.getMessage());//берем сообщение из параметра конструктора исключения
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
