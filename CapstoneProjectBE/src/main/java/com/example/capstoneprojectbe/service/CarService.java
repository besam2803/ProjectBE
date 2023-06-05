package com.example.capstoneprojectbe.service;

import com.example.capstoneprojectbe.model.dto.CarDto;
import com.example.capstoneprojectbe.model.dto.UserDto;
import com.example.capstoneprojectbe.model.response.CarEntity;
import com.example.capstoneprojectbe.model.response.UserEntity;
import com.example.capstoneprojectbe.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    private final UserRepository userRepository;

    private final ShowroomRepository showroomRepository;

    private final CarBrandRepository carBrandRepository;

    private final CarTypeRepository carTypeRepository;

    public boolean isExisted(String id) {
        return carRepository.existsById(id);
    }

    public CarEntity getCarByCarID(String id) {
        return CarEntity.fromCarDto(carRepository.getById(id));
    }

    public List<CarEntity> getCarByShowroomID(String id) {
        return carRepository.getCarByShowRoomID(id).stream()
                .map(CarEntity::fromCarDto)
                .collect(Collectors.toList());
    }

    public List<CarEntity> getCarByUserID(String id) {
        return carRepository.getCarByUserID(id).stream()
                .map(CarEntity::fromCarDto)
                .collect(Collectors.toList());
    }

    public CarEntity createNewCar(CarEntity entity) {
        CarDto dto = CarDto.builder()
                .carID(entity.getCarID())
                .carName(entity.getCarName())
                .carBrandDto(carBrandRepository.findById(entity.getCarBrandID()).orElseThrow())
                .carPrice(entity.getCarPrice())
                .carTypeDto(carTypeRepository.findById(entity.getCarTypeID()).orElseThrow())
                .yearOfRegistration(entity.getYearOfRegistration())
                .carOdo(entity.getCarOdo())
                .carOrigin(entity.getCarOrigin())
                .carDescription(entity.getCarDescription())
                .carCondition(entity.getCarCondition())
                .carStatus(entity.isCarStatus())
                .userDto(userRepository.findById(entity.getUserID()).orElseThrow())
                .showroomDto(showroomRepository.findById(entity.getShowroomID()).orElseThrow())
                .build();

        return CarEntity.fromCarDto(carRepository.save(dto));
    }


    public CarEntity updateExistedCar(CarEntity entity) {
        CarDto dto = carRepository.findById(entity.getCarID()).orElseThrow();

        dto.setCarName(entity.getCarName());
        dto.setCarBrandDto(carBrandRepository.findById(entity.getCarBrandID()).orElseThrow());
        dto.setCarPrice(entity.getCarPrice());
        dto.setCarTypeDto(carTypeRepository.findById(entity.getCarTypeID()).orElseThrow());
        dto.setYearOfRegistration(entity.getYearOfRegistration());
        dto.setCarOdo(entity.getCarOdo());
        dto.setCarOrigin(entity.getCarOrigin());
        dto.setCarDescription(entity.getCarDescription());
        dto.setCarCondition(entity.getCarCondition());
        dto.setCarStatus(entity.isCarStatus());
        dto.setUserDto(userRepository.findById(entity.getUserID()).orElseThrow());
        dto.setShowroomDto(showroomRepository.findById(entity.getShowroomID()).orElseThrow());

        return CarEntity.fromCarDto(carRepository.save(dto));
    }

    public CarEntity deleteExistedCar(String id) {
        CarDto dto = carRepository.findById(id).orElseThrow();
        carRepository.deleteById(id);
        return CarEntity.fromCarDto(dto);
    }



}
