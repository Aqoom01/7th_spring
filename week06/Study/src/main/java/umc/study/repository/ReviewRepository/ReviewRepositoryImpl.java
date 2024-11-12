package umc.study.repository.ReviewRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.QReview;
import umc.study.domain.QStore;
import umc.study.domain.Review;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    private final QReview review = QReview.review;
    private final QStore store = QStore.store;

    @Override
    public List<Review> findReviewsByStoreId(Long StoreId) {
        BooleanBuilder predicate = new BooleanBuilder();
        if(StoreId != null) {
            predicate.and(store.id.eq(StoreId));
        }

        return queryFactory
                .select(review)
                .from(review)
                .join(review.store, store).on(store.id.eq(StoreId))
                .fetch();
    }
}
