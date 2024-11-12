package umc.study.service.MemberMissionService;

import com.querydsl.core.Tuple;
import umc.study.domain.enums.MissionStatus;

import java.util.List;

public interface MemberMissionService {
    List<Tuple> findStoresAndMissionByIdAndStatus(Long id, MissionStatus status);

}
