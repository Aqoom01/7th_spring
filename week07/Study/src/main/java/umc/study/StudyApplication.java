package umc.study;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import umc.study.domain.Member;
import umc.study.domain.enums.MissionStatus;
import umc.study.service.MemberMissionService.MemberMissionService;
import umc.study.service.MemberService.MemberService;
import umc.study.service.ReviewService.ReviewService;
import umc.study.service.StoreService.StoreQueryService;

@SpringBootApplication
@EnableJpaAuditing
public class StudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyApplication.class, args);
    }

    //@Bean
    //public CommandLineRunner run(ApplicationContext context) {
        /*
        return args -> {
            StoreQueryService storeService = context.getBean(StoreQueryService.class);
            MemberMissionService memberMissionService = context.getBean(MemberMissionService.class);
            ReviewService reviewService = context.getBean(ReviewService.class);
            MemberService memberService = context.getBean(MemberService.class);

            // 파라미터 값 설정
            String name = "요아정";
            Float score = 4.0f;

            // 쿼리 메서드 호출 및 쿼리 문자열과 파라미터 출력
            System.out.println("Executing findStoresByNameAndScore with parameters:");
            System.out.println("Name: " + name);
            System.out.println("Score: " + score);

            storeService.findStoresByNameAndScore(name, score)
                    .forEach(System.out::println);

            System.out.println();
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Mission 01");

            Long member_id = 1L;
            MissionStatus status = MissionStatus.SUCCEEDED;

            memberMissionService.findStoresAndMissionByIdAndStatus(member_id, status)
                    .forEach(System.out::println);

            System.out.println();
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Mission 02");

            Long Store_Id = 1L;
            reviewService.findReviewsByStoreId(Store_Id)
                    .forEach(System.out::println);

            System.out.println();
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Mission 03");

            Long region_id = 1L;

            memberService.getHome(member_id, region_id)
                    .forEach(System.out::println);

            System.out.println();
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Mission 04");

            Member member = memberService.findMemberById(member_id);
            System.out.println(member);
        };
         */

    //}
}
