package chanyoung.GoodNightHackathon.global;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // spring 의 예외 처리를 위한 기능 지원
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(value = RuntimeException.class)
    public String handleException (RuntimeException e) {
        return "Error : " + e.getMessage();
    }
}
