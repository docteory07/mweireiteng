package com.docteory07.mweireiteng.review.repository;

import com.docteory07.mweireiteng.review.entity.Malatang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MalatangRepository extends JpaRepository<Malatang, Integer> {
    List<Malatang> findByReview_Id(int id);
}
