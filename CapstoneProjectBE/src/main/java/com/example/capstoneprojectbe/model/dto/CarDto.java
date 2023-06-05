package com.example.capstoneprojectbe.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_car")
public class CarDto {
    @Id
    private String carID;

    private String carName;

    //private String carBrand;

    private float carPrice;

   // private String carType;

    private int yearOfRegistration;

    private int carOdo;

    private String carOrigin;

    private String carDescription;

    private String carCondition;

    private boolean carStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private UserDto userDto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "showroomID")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private ShowroomDto showroomDto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carBrandID")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private CarBrandDto carBrandDto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carTypeID")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private CarTypeDto carTypeDto;

}