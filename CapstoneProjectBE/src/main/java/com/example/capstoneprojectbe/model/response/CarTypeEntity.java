package com.example.capstoneprojectbe.model.response;

import com.example.capstoneprojectbe.model.dto.CarTypeDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarTypeEntity {

    private String carTypeID;

    private String carTypeName;

    public static CarTypeEntity fromCarTypeDto(CarTypeDto dto) {
        return CarTypeEntity.builder()
                .carTypeID(dto.getCarTypeID())
                .carTypeName(dto.getCarTypeName())
                .build();
    }

}
