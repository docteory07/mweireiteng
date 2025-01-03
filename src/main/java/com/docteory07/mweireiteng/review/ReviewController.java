package com.docteory07.mweireiteng.review;

import com.docteory07.mweireiteng.ingredient.IngredientService;
import com.docteory07.mweireiteng.ingredient.entity.Ingredient;
import com.docteory07.mweireiteng.restaurant.Restaurant;
import com.docteory07.mweireiteng.restaurant.RestaurantService;
import com.docteory07.mweireiteng.review.entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/review")
@Controller
public class ReviewController {

    private final ReviewService reviewService;
    private final RestaurantService restaurantService;
    private final IngredientService ingredientService;

    @GetMapping
    public String getReviewList(
            Model model,
            @RequestParam(value = "page", defaultValue = "0") int page
    ) {
        Page<Review> paging = reviewService.getList(page);
        model.addAttribute("paging", paging);
        HashMap<Integer, Integer> reviewWeight = new HashMap<>();
        for (int i = 0; i < paging.getTotalElements(); i++) {
            int reviewId = paging.getContent().get(i).getId();
            reviewWeight.put(reviewId, reviewService.getWeight(reviewId));
        }
        model.addAttribute("reviewWeight", reviewWeight);

        return "review/list";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/create")
    public String getCreateReview(CreateReviewDto dto, Model model) {
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        List<Ingredient> ingredients = ingredientService.getAllIngredients();

        model.addAttribute("restaurants", restaurants);
        model.addAttribute("ingredients", ingredients);

        return "review/create";
    }
}
