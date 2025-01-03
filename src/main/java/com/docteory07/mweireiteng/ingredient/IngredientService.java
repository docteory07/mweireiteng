package com.docteory07.mweireiteng.ingredient;

import com.docteory07.mweireiteng.ingredient.entity.Ingredient;
import com.docteory07.mweireiteng.ingredient.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }
}
