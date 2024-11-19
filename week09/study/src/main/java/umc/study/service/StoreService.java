package umc.study.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.ApiResponse;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.FoodCategoryHandler;
import umc.study.apiPayload.exception.handler.RegionHandler;
import umc.study.converter.StoreConverter;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.MissionRepository;
import umc.study.repository.RegionRepository;
import umc.study.repository.ReviewRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;

    @Transactional
    public Store joinRegion(StoreRequestDTO.JoinDTO request) {
        Store store = storeRepository.findById(request.getStoreId()).orElse(null);
        store.setRegion(regionRepository.findById(request.getRegionId()).orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND)));
        return storeRepository.save(store);
    }

    public boolean isExistsinRepo(Long storeIds) {
        return storeRepository.existsById(storeIds);
    }

    public Page<Review> getReviewList(Long StoreId, Integer page) {
        Store store = storeRepository.findById(StoreId).get();
        Page<Review> StorePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return StorePage;
    }

    @Transactional
    public Page<Mission> getStoreMissions(Long StoreId, Integer page) {
        Store store = storeRepository.findById(StoreId).get();
        Page<Mission> missionPage = missionRepository.findAllByStore(store, PageRequest.of(page, 10));
        return missionPage;
    }
}
