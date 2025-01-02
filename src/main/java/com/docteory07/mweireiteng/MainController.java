package com.docteory07.mweireiteng;

import com.docteory07.mweireiteng.restaurant.Restaurant;
import com.docteory07.mweireiteng.restaurant.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final RestaurantService restaurantService;

    @GetMapping("/")
    public String index() {

        return "index";
    }

    @GetMapping("/api/restaurant")
    public ResponseEntity<List<Restaurant>> getRestaurants(@RequestParam String value) {
        List<Restaurant> restaurants = restaurantService.getRestaurantsByAddress(value);

        if (restaurants.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(restaurants); // 204 No Content
        }

        return ResponseEntity.ok(restaurants);
    }

}
