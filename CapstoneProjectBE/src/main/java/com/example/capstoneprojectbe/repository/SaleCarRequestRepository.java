package com.example.capstoneprojectbe.repository;

import com.example.capstoneprojectbe.model.dto.BuyCarRequestDto;
import com.example.capstoneprojectbe.model.dto.SaleCarRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleCarRequestRepository extends JpaRepository<SaleCarRequestDto, String> {

    @Query("select dto from SaleCarRequestDto dto where dto.showroomDto.showroomID = ?1")
    List<SaleCarRequestDto> getSaleCarByShowRoomID(String id);

    @Query("select dto from SaleCarRequestDto dto where dto.userDto.userID = ?1")
    List<SaleCarRequestDto> getSaleCarByUserID(String id);

    @Query("select dto from SaleCarRequestDto dto where dto.carDto.carID = ?1")
    List<SaleCarRequestDto> getSaleCarByCarID(String id);
}
