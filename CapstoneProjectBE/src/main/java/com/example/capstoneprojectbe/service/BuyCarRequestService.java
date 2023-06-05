package com.example.capstoneprojectbe.service;

import com.example.capstoneprojectbe.model.dto.BuyCarRequestDto;
import com.example.capstoneprojectbe.model.response.BuyCarRequestEntity;
import com.example.capstoneprojectbe.repository.BuyCarRequestRepository;
import com.example.capstoneprojectbe.repository.CarRepository;
import com.example.capstoneprojectbe.repository.ShowroomRepository;
import com.example.capstoneprojectbe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BuyCarRequestService {

    private final BuyCarRequestRepository buyCarRequestRepository;

    private final CarRepository carRepository;

    private final UserRepository userRepository;

    private final ShowroomRepository showroomRepository;

    public boolean isExisted(String id) {
        return buyCarRequestRepository.existsById(id);
    }

    public BuyCarRequestEntity getBuyCarByBuyCarID(String id) {
        return BuyCarRequestEntity.fromBuyCarRequestDto(buyCarRequestRepository.getById(id));
    }

    public List<BuyCarRequestEntity> getBuyCarByShowroomID(String id) {
        return buyCarRequestRepository.getBuyCarByShowRoomID(id).stream()
                .map(BuyCarRequestEntity::fromBuyCarRequestDto)
                .collect(Collectors.toList());
    }

    public List<BuyCarRequestEntity> getBuyCarByUserID(String id) {
        return buyCarRequestRepository.getBuyCarByUserID(id).stream()
                .map(BuyCarRequestEntity::fromBuyCarRequestDto)
                .collect(Collectors.toList());
    }

    public List<BuyCarRequestEntity> getBuyCarByCarID(String id) {
        return buyCarRequestRepository.getBuyCarByCarID(id).stream()
                .map(BuyCarRequestEntity::fromBuyCarRequestDto)
                .collect(Collectors.toList());
    }

    public BuyCarRequestEntity createNewBuyCarRequest(BuyCarRequestEntity entity) {
        BuyCarRequestDto dto = BuyCarRequestDto.builder()
                .buyCarID(entity.getBuyCarID())
                .status(entity.isStatus())
                .date(entity.getDate())
                .userDto(userRepository.findById(entity.getUserID()).orElseThrow())
                .carDto(carRepository.findById(entity.getCarID()).orElseThrow())
                .showroomDto(showroomRepository.findById(entity.getShowroomID()).orElseThrow())
                .build();

        return BuyCarRequestEntity.fromBuyCarRequestDto(dto);
    }


    public BuyCarRequestEntity updateExistedBuyCarRequest(BuyCarRequestEntity entity) {
        BuyCarRequestDto dto = buyCarRequestRepository.findById(entity.getBuyCarID()).orElseThrow();

        dto.setDate(entity.getDate());
        dto.setStatus(entity.isStatus());
        dto.setCarDto(carRepository.findById(entity.getUserID()).orElseThrow());
        dto.setUserDto(userRepository.findById(entity.getUserID()).orElseThrow());
        dto.setShowroomDto(showroomRepository.findById(entity.getShowroomID()).orElseThrow());

        return BuyCarRequestEntity.fromBuyCarRequestDto(buyCarRequestRepository.save(dto));
    }

    public BuyCarRequestEntity deleteExistedBuyCarRequest(String id) {
        BuyCarRequestDto dto = buyCarRequestRepository.findById(id).orElseThrow();
        buyCarRequestRepository.deleteById(id);
        return BuyCarRequestEntity.fromBuyCarRequestDto(dto);
    }


}
