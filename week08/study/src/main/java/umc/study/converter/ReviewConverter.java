package umc.study.converter;

import umc.study.domain.Review;
import umc.study.domain.ReviewImage;
import umc.study.web.dto.WriteReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewImage UrltoPictures(String url) {
        return ReviewImage.builder()
                .imageUrl(url).build();
    }

    public static WriteReviewResponseDTO.WriteReviewResponseDTOBuilder toWriteResultDTO(Review review) {
        return WriteReviewResponseDTO.WriteReviewResponseDTOBuilder.builder()
                .reviewId(review.getId())
                .createTime(LocalDateTime.now())
                .build();
    }
}
