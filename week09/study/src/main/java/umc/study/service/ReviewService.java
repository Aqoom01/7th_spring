package umc.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.ReviewConverter;
import umc.study.domain.*;
import umc.study.repository.ReviewImageRepository;
import umc.study.repository.ReviewRepository;
import umc.study.repository.MemberRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.WriteReviewRequestDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final ReviewImageRepository reviewImageRepository;

    @Transactional
    public Review write(Long memberId, Long shopId, WriteReviewRequestDTO.ReviewWriteRequestDTO request) {
        Member writer = memberRepository.findById(memberId).orElse(null);
        Store written = storeRepository.findById(shopId).orElse(null);

        List<ReviewImage> reviewImageList = new ArrayList<>();
        for(int i = 0; i < request.getReviewPic().size(); i++ ) {
            reviewImageRepository.save(ReviewConverter.UrltoPictures(request.getReviewPic().get(i)));
            reviewImageList.add(ReviewConverter.UrltoPictures(request.getReviewPic().get(i)));
        }

        Review newReview = new Review().builder()
                .body(request.getReviewText())
                .score(request.getReviewScore())
                .member(writer)
                .store(written)
                .reviewImageList(reviewImageList)
                .build();
        return reviewRepository.save(newReview);
    }
}
