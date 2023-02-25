package com.techeer.goodnight.domain.restaurant.dto.mapper;

import com.techeer.goodnight.domain.restaurant.dto.response.RestaruantResponseDto;
import com.techeer.goodnight.domain.restaurant.dto.request.RestaruantUpdateRequestDto;
import com.techeer.goodnight.domain.restaurant.dto.request.RestaruantCreateRequestDto;
import com.techeer.goodnight.domain.restaurant.entity.Restaruant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestaruantMapper {
    public RestaruantResponseDto toResponseDto(Restaruant data){ // Restaruant 엔티티 데이터를 Dto로 매핑하는 것. 원하는 것을 가져오기
        return RestaruantResponseDto.builder()
                .id(data.getId())
                .name(data.getName())
                .content(data.getContent())
                .activated(data.getActivated())
                .build();
    }

    public Restaruant toEntity(RestaruantUpdateRequestDto dto) {
        return Restaruant.builder()
                .id(dto.getId())
                .name(dto.getName())
                .content(dto.getContent())
                .activated(dto.getActivated())
                .build();
    }

    public Restaruant toEntity(RestaruantCreateRequestDto dto) {
        return Restaruant.builder()
                .name(dto.getName())
                .content(dto.getContent())
                .activated(dto.getActivated())
                .build();
    }
}