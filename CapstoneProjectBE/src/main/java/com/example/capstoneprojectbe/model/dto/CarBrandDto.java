package com.example.capstoneprojectbe.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_carbrand")
public class CarBrandDto {
    @Id
    private String carBrandID;

    private String carBrandName;

    private String logoUrl;


}
