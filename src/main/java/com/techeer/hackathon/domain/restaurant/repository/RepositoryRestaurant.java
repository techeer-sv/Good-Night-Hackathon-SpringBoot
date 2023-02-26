package com.techeer.hackathon.domain.restaurant.repository;

import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryRestaurant extends JpaRepository<Restaurant, Long> {

}
