package com.techeer.goodnighthackathonspringboot.domain.hello.service;

import com.techeer.goodnighthackathonspringboot.domain.hello.domain.entity.Hello;
import com.techeer.goodnighthackathonspringboot.domain.hello.domain.repository.HelloRepository;
import com.techeer.goodnighthackathonspringboot.domain.hello.dto.HelloDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloService {
    private final HelloRepository helloRepository;
    public HelloDto create(HelloDto dto){
        String contents = dto.getContents();
        Hello entity = Hello.builder()
                .contents(contents)
                .build();
        helloRepository.save(entity);
        return HelloDto.builder().build().id(savedEntity.getId()).contents();
    }
    public HelloDto delete(HelloDto dto){
        helloRepository.deleteById(dto.getId());
    }
}
