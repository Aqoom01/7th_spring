package umc.study.repository.MemberMissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.QMember;
import umc.study.domain.QMission;
import umc.study.domain.QStore;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.QMemberMission;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMemberMission memberMission = QMemberMission.memberMission;
    private final QMember member = QMember.member;
    private final QMission mission = QMission.mission;
    private final QStore store = QStore.store;

    @Override
    public List<Tuple> dynamicQueryWithMap(Long Id, MissionStatus status) {
        BooleanBuilder predicate = new BooleanBuilder();

        if(Id != null) {
            predicate.and(memberMission.member.id.eq(Id));
        }
        if(status != null) {
            predicate.and(memberMission.status.eq(status));
        }

        return jpaQueryFactory
                .select(mission.missionSpec, store.name, mission.reward)
                .from(member)
                .join(memberMission.member, member).on(member.id.eq(Id))
                .join(memberMission.mission, mission).on(memberMission.status.eq(status))
                .join(mission.store, store)
                .fetch();
    }
}
