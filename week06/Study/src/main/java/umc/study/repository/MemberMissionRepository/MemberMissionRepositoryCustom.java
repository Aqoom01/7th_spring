package umc.study.repository.MemberMissionRepository;

import com.querydsl.core.Tuple;
import umc.study.domain.enums.MissionStatus;

import java.util.List;

public interface MemberMissionRepositoryCustom {
    List<Tuple> dynamicQueryWithMap(Long id, MissionStatus status);

}
