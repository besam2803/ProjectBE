package com.example.capstoneprojectbe.model.response;

import com.example.capstoneprojectbe.model.dto.CarDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarEntity {
    private String carID;

    private String carName;

    private String carBrandID;

    private float carPrice;

    private String carTypeID;

    private int yearOfRegistration;

    private int carOdo;

    private String carOrigin;

    private String carDescription;

    private String carCondition;

    private boolean carStatus;

    private String userID;

    private String showroomID;

    public static CarEntity fromCarDto(CarDto dto) {
        return CarEntity.builder()
                .carID(dto.getCarID())
                .carName(dto.getCarName())
                .carBrandID(dto.getCarBrandDto().getCarBrandID())
                .carPrice(dto.getCarPrice())
                .carTypeID(dto.getCarTypeDto().getCarTypeID())
                .yearOfRegistration(dto.getYearOfRegistration())
                .carOdo(dto.getCarOdo())
                .carOrigin(dto.getCarOrigin())
                .carDescription(dto.getCarDescription())
                .carCondition(dto.getCarCondition())
                .carStatus(dto.isCarStatus())
                .userID(dto.getUserDto().getUserID())
                .showroomID(dto.getShowroomDto().getShowroomID())
                .build();
    }

}
