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

    @PostMapping
    public HelloDto create(@RequestBody HelloDto dto){
        return helloService.create(dto);
    }

    @DeleteMapping
    public void delete(@RequestBody HelloDto dto){
        helloService.delete(dto);
    }

    @GetMapping
    public String test(){
        return "Test";
    }
}
