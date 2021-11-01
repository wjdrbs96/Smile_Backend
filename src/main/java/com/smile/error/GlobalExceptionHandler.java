package com.smile.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ModelAttribute("userId")
    public Long resolveUserId() {
        return 1L;
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public String entityNotFoundException() {
        return "error";
    }

}