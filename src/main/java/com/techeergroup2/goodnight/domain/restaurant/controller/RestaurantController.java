package com.techeergroup2.goodnight.domain.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@RequestMapping("/restaurants")
@RestController
public class RestaurantController {

    @GetMapping
    public String getRestaurants() {
        return "hello";
    }
}
