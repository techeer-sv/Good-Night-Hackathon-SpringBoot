package com.techeer.goodnighthackathonspringboot.domain.hello.controller;

import com.techeer.goodnighthackathonspringboot.domain.hello.dto.HelloDto;
import com.techeer.goodnighthackathonspringboot.domain.hello.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hello")
@RequiredArgsConstructor
public class HelloController {
    private final HelloService helloService;

    @PostMapping // @RequestMapping("/api/v1/hello") 를 post 로 보내면 실행
    public HelloDto create(@RequestBody HelloDto dto){
        return helloService.create(dto);
    }
    @DeleteMapping
    public void delete(@RequestBody HelloDto dto){
        helloService.delete(dto); //url로 deletemethod 면 실행
    }
    @GetMapping
    public String test(){
        return "TEST"; //url로 getmethod 면 실행
    }

}
