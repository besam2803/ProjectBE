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
@Table(name = "tbl_salecarrequest")
public class SaleCarRequestDto {

    @Id
    private String saleCarID;

    private boolean status;

    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private UserDto userDto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "showroomID")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private ShowroomDto showroomDto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carID")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private CarDto carDto;

}
