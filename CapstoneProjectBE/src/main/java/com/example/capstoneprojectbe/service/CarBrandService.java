package com.example.capstoneprojectbe.service;

import com.example.capstoneprojectbe.model.dto.CarBrandDto;
import com.example.capstoneprojectbe.model.dto.CarTypeDto;
import com.example.capstoneprojectbe.model.response.CarBrandEntity;
import com.example.capstoneprojectbe.model.response.CarTypeEntity;
import com.example.capstoneprojectbe.repository.CarBrandRepository;
import com.example.capstoneprojectbe.repository.CarTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarBrandService {

    private final CarBrandRepository carBrandRepository;

    public boolean isExisted(String id) {
        return carBrandRepository.existsById(id);
    }

    public CarBrandEntity createNewCarBrand(CarBrandEntity entity) {
        CarBrandDto dto = CarBrandDto.builder()
                .carBrandID(entity.getCarBrandID())
                .carBrandName(entity.getCarBrandName())
                .logoUrl(entity.getLogoUrl())
                .build();

        return CarBrandEntity.fromCarBrandDto(carBrandRepository.save(dto));
    }

    public List<CarBrandEntity> getAllCarBrands() {
        return carBrandRepository.findAll().stream()
                .map(CarBrandEntity::fromCarBrandDto)
                .collect(Collectors.toList());
    }

    public CarBrandEntity updateExistedCarBrand(CarBrandEntity entity) {
        CarBrandDto dto = carBrandRepository.findById(entity.getCarBrandID()).orElseThrow();

        dto.setCarBrandID(entity.getCarBrandID());
        dto.setCarBrandName(entity.getCarBrandName());
        dto.setLogoUrl(entity.getLogoUrl());

        return CarBrandEntity.fromCarBrandDto(carBrandRepository.save(dto));
    }

    public CarBrandEntity deleteExistedCarBrand(String id) {
        CarBrandDto dto = carBrandRepository.findById(id).orElseThrow();
        carBrandRepository.deleteById(id);
        return CarBrandEntity.fromCarBrandDto(dto);
    }


    public CarBrandEntity getCarBrandByCarBrandID(String id) {
        return CarBrandEntity.fromCarBrandDto(carBrandRepository.getById(id));
    }
}
