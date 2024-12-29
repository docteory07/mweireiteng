package com.docteory07.mweireiteng.ingredient.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Table(name = "ingredient_type")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    public Type(String name) {
        this.name = name;
    }
}
