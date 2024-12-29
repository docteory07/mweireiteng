package com.docteory07.mweireiteng.review.entity;

import com.docteory07.mweireiteng.ingredient.entity.Ingredient;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "malatangs")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Malatang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer weight;

    @ManyToOne
    private Review review;

    @ManyToOne
    private Ingredient ingredient;

    public Malatang(int weight, Review review, Ingredient ingredient) {
        this.weight = weight;
        this.review = review;
        this.ingredient = ingredient;
    }
}
