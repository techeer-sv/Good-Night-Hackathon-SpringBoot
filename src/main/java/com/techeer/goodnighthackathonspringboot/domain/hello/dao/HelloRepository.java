package com.techeer.goodnighthackathonspringboot.domain.hello.dao;

import com.techeer.goodnighthackathonspringboot.domain.hello.domain.entity.Hello;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HelloRepository extends JpaRepository<Hello, Long> {
    Optional<Hello> findById(Long id);
    void deleteById(Long id);
}
