package umc.study.service.MemberMissionService;

import com.querydsl.core.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.enums.MissionStatus;
import umc.study.repository.MemberMissionRepository.MemberMissionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionServiceImpl implements MemberMissionService {
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public List<Tuple> findStoresAndMissionByIdAndStatus(Long Id, MissionStatus status) {
        return memberMissionRepository.dynamicQueryWithMap(Id, status);
    }
}
