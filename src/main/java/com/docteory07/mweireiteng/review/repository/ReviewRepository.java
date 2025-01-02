package com.docteory07.mweireiteng.review.repository;

import com.docteory07.mweireiteng.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    Page<Review> findAll(Pageable pageable);
}
