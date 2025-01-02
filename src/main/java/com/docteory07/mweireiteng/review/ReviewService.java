package com.docteory07.mweireiteng.review;

import com.docteory07.mweireiteng.review.entity.Malatang;
import com.docteory07.mweireiteng.review.entity.Review;
import com.docteory07.mweireiteng.review.repository.MalatangRepository;
import com.docteory07.mweireiteng.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MalatangRepository malatangRepository;

    public Page<Review> getList(int page) {
        // 최신순
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createdAt"));

        Pageable pageable = PageRequest.of(page, 6, Sort.by(sorts));
        return reviewRepository.findAll(pageable);

//        return reviewRepository.findAll(PageRequest.of(page, 6));
    }

    public int getWeight(int id) {
        List<Malatang> malatangs = malatangRepository.findByReview_Id(id);

        return malatangs.stream().mapToInt(Malatang::getWeight).sum();
    }
}
