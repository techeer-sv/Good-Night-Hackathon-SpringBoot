package com.techeer.goodnighthackathonspringboot.domain.hello.domain.repository;

import com.techeer.goodnighthackathonspringboot.domain.hello.domain.entity.Hello;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HelloRepository extends JpaRepository<Hello, Long> {
    Optional<Hello> findById(Long id); //sql문 만들어짐
    void deleteById(Long id);

}
