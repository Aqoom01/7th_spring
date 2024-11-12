package umc.study.service.ReviewService;

import umc.study.domain.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findReviewsByStoreId(Long StoreId);
}
