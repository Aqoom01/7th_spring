package umc.study.repository.MemberRepository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.*;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.QMemberMission;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {
    private JPAQueryFactory queryFactory;
    private QMember member = QMember.member;
    private QRegion region = QRegion.region;
    private QMemberMission memberMission = QMemberMission.memberMission;
    private QStore store = QStore.store;
    private QMission mission = QMission.mission;

    @Override
    public Member findMemberById(Long id) {
        return queryFactory.select(member).from(member).where(member.id.eq(id)).fetchOne();
    }

    @Override
    public List<Tuple> getHome(Long member_id, Long region_id) {
        return queryFactory
                .select(member.point, memberMission.mission, mission.missionSpec, mission.deadline, mission.reward, region.name)
                .join(store.region, region).on(region.id.eq(region_id))
                .join(member, memberMission.member).on(member.id.eq(member_id))
                .join(mission, memberMission.mission)
                .join(mission.store, store)
                .where(memberMission.status.eq(MissionStatus.IN_PROGRESS))
                .fetch();
    }
}
