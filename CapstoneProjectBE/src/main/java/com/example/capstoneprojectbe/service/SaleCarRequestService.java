package com.example.capstoneprojectbe.service;

import com.example.capstoneprojectbe.model.dto.BuyCarRequestDto;
import com.example.capstoneprojectbe.model.dto.SaleCarRequestDto;
import com.example.capstoneprojectbe.model.response.BuyCarRequestEntity;
import com.example.capstoneprojectbe.model.response.SaleCarRequestEntity;
import com.example.capstoneprojectbe.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SaleCarRequestService {

    private final SaleCarRequestRepository saleCarRequestRepository;

    private final CarRepository carRepository;

    private final UserRepository userRepository;

    private final ShowroomRepository showroomRepository;

    public boolean isExisted(String id) {
        return saleCarRequestRepository.existsById(id);
    }

    public SaleCarRequestEntity getSaleCarBySaleCarID(String id) {
        return SaleCarRequestEntity.fromSaleCarRequestDto(saleCarRequestRepository.getById(id));
    }

    public List<SaleCarRequestEntity> getSaleCarByShowRoomID(String id) {
        return saleCarRequestRepository.getSaleCarByShowRoomID(id).stream()
                .map(SaleCarRequestEntity::fromSaleCarRequestDto)
                .collect(Collectors.toList());
    }

    public List<SaleCarRequestEntity> getSaleCarByUserID(String id) {
        return saleCarRequestRepository.getSaleCarByUserID(id).stream()
                .map(SaleCarRequestEntity::fromSaleCarRequestDto)
                .collect(Collectors.toList());
    }

    public List<SaleCarRequestEntity> getSaleCarByCarID(String id) {
        return saleCarRequestRepository.getSaleCarByCarID(id).stream()
                .map(SaleCarRequestEntity::fromSaleCarRequestDto)
                .collect(Collectors.toList());
    }

    public SaleCarRequestEntity createNewSaleCarRequest(SaleCarRequestEntity entity) {
        SaleCarRequestDto dto = SaleCarRequestDto.builder()
                .saleCarID(entity.getSaleCarID())
                .status(entity.isStatus())
                .date(entity.getDate())
                .userDto(userRepository.findById(entity.getUserID()).orElseThrow())
                .carDto(carRepository.findById(entity.getCarID()).orElseThrow())
                .showroomDto(showroomRepository.findById(entity.getShowroomID()).orElseThrow())
                .build();

        return SaleCarRequestEntity.fromSaleCarRequestDto(dto);
    }


    public SaleCarRequestEntity updateExistedSaleCarRequest(SaleCarRequestEntity entity) {
        SaleCarRequestDto dto = saleCarRequestRepository.findById(entity.getSaleCarID()).orElseThrow();

        dto.setDate(entity.getDate());
        dto.setStatus(entity.isStatus());
        dto.setCarDto(carRepository.findById(entity.getUserID()).orElseThrow());
        dto.setUserDto(userRepository.findById(entity.getUserID()).orElseThrow());
        dto.setShowroomDto(showroomRepository.findById(entity.getShowroomID()).orElseThrow());

        return SaleCarRequestEntity.fromSaleCarRequestDto(saleCarRequestRepository.save(dto));
    }

    public SaleCarRequestEntity deleteExistedSaleCarRequest(String id) {
        SaleCarRequestDto dto = saleCarRequestRepository.findById(id).orElseThrow();
        saleCarRequestRepository.deleteById(id);
        return SaleCarRequestEntity.fromSaleCarRequestDto(dto);
    }
}
