package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.enums.Gender;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request) {
        Gender gender = null;

        switch (request.getGender()) {
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .build();
    }

    public static MemberResponseDTO.ownReviewsDTO toOwnReivewResponseDTO(Review review) {
        return MemberResponseDTO.ownReviewsDTO.builder()
                .reviewId(review.getId())
                .reviewBody(review.getBody())
                .reviewScore(review.getScore())
                .createdAt(review.getCreatedAt())
                .storeName(review.getStore().getName())
                .build();
    }

    public static MemberResponseDTO.ownReviewListDTO toOwnReivewListResponseDTO(Page<Review> reviews) {
        List<MemberResponseDTO.ownReviewsDTO> ownReviewsListDTO = reviews.stream()
                .map(MemberConverter::toOwnReivewResponseDTO).collect(Collectors.toList());

        return MemberResponseDTO.ownReviewListDTO.builder()
                .isFirst(reviews.isFirst())
                .isLast(reviews.isLast())
                .totalPage(reviews.getTotalPages())
                .totalElements(reviews.getTotalElements())
                .listSize(ownReviewsListDTO.size())
                .ownreviews(ownReviewsListDTO)
                .build();
    }
}
