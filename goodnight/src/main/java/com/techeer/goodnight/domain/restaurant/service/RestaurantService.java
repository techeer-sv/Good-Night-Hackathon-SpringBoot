package com.techeer.goodnight.domain.restaurant.service;

import com.techeer.goodnight.domain.restaurant.dto.mapper.RestaruantMapper;
import com.techeer.goodnight.domain.restaurant.dto.request.RestaruantCreateRequestDto;
import com.techeer.goodnight.domain.restaurant.dto.request.RestaruantUpdateRequestDto;
import com.techeer.goodnight.domain.restaurant.entity.Restaruant;
import com.techeer.goodnight.domain.restaurant.repository.RestaurantRepository;
import com.techeer.goodnight.domain.restaurant.exception.NotFoundTestDataEntityException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor // final 멤버 변수용 생성자
public class RestaurantService {
    private final RestaurantRepository testRepository;
    private final RestaruantMapper mapper;

    public Restaruant create(RestaruantCreateRequestDto dto){

        Restaruant entity = mapper.toEntity(dto);
        return testRepository.save(entity);
    }

    public Restaruant findById(UUID id) {
        return findRestaruantById(id);
    }

    public void deleteById(UUID id){
        testRepository.deleteById(id);
    }

    public Restaruant update(RestaruantUpdateRequestDto dto) {
        Restaruant newTestData = findRestaruantById(dto.getId());
        newTestData.update(dto.getName(), dto.getContent(), dto.getActivated());
        return testRepository.save(newTestData);
    }

    private Restaruant findRestaruantById(UUID id) {
        return testRepository.findById(id).orElseThrow(
                NotFoundTestDataEntityException::new
        );
    }
}
