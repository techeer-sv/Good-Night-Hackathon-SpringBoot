package com.techeer.goodnighthackathonspringboot.domain.hello.service;

import com.techeer.goodnighthackathonspringboot.domain.hello.domain.entity.Hello;
import com.techeer.goodnighthackathonspringboot.domain.hello.dao.HelloRepository;
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
        Hello savedEntity = helloRepository.save(entity);
        return HelloDto.builder().id(savedEntity.getId()).contents(savedEntity.getContents()).build();
    }

    public void delete(HelloDto dto){
        helloRepository.deleteById(dto.getId());
    }
}
