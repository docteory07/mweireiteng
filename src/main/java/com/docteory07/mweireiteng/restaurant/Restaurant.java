package com.docteory07.mweireiteng.restaurant;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Getter
@Entity
@Table(name = "restaurants")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Setter
    private String branch;

    @Column(nullable = false)
    private String address;

    @Setter
    private String tel;

    private Time open;
    private Time close;

    @Setter
    private String img;

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void setTime(Time open, Time close) {
        this.open = open;
        this.close = close;
    }
}
