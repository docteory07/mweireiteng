package com.docteory07.mweireiteng.review.entity;

import com.docteory07.mweireiteng.user.User;
import com.docteory07.mweireiteng.restaurant.Restaurant;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Table(name = "reviews")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter
    @Column(nullable = false)
    private String title;

    @Setter
    private String content;

    @Setter
    @Column(nullable = false)
    private Integer hot;

    @Setter
    @Column(nullable = false)
    private Integer mala;

    @Setter
    @Column(nullable = false)
    private Integer rating;

    @Setter
    @Column(nullable = false)
    private Integer recommend;

    @ManyToOne
    private User user;

    @ManyToOne
    private Restaurant restaurant;

    public Review(String title, String content, int hot, int mala, int rating, int recommend, User user, Restaurant restaurant) {
        this.title = title;
        this.content = content;
        this.hot = hot;
        this.mala = mala;
        this.rating = rating;
        this.recommend = recommend;
        this.user = user;
        this.restaurant = restaurant;
    }
}
