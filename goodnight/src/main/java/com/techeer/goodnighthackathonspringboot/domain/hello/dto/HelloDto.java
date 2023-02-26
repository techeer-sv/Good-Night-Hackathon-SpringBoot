package com.techeer.goodnighthackathonspringboot.domain.hello.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class HelloDto {
    private Long id;
    private String contents;

    // setter = public void update(){}
}
