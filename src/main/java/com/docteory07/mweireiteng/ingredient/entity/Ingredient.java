package com.docteory07.mweireiteng.ingredient.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "ingredients")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String ingredient;

    @ManyToOne
    private Type type;

    public Ingredient(String ingredient, Type type) {
        this.ingredient = ingredient;
        this.type = type;
    }
}
