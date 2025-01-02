package com.docteory07.mweireiteng.restaurant;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public Restaurant getRestaurant(int id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        return restaurant.orElse(null);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public List<Restaurant> getRestaurantsByAddress(String value) {
        List<Restaurant> restaurants = restaurantRepository.findByNameContainingOrAddressContaining(value, value);
        return restaurants != null ? restaurants : Collections.emptyList();
    }
}
