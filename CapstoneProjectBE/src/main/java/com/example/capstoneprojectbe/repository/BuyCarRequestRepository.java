package com.example.capstoneprojectbe.repository;

import com.example.capstoneprojectbe.model.dto.BuyCarRequestDto;
import com.example.capstoneprojectbe.model.dto.CarDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyCarRequestRepository extends JpaRepository<BuyCarRequestDto, String> {

    @Query("select dto from BuyCarRequestDto dto where dto.showroomDto.showroomID = ?1")
    List<BuyCarRequestDto> getBuyCarByShowRoomID(String id);

    @Query("select dto from BuyCarRequestDto dto where dto.userDto.userID = ?1")
    List<BuyCarRequestDto> getBuyCarByUserID(String id);

    @Query("select dto from BuyCarRequestDto dto where dto.carDto.carID = ?1")
    List<BuyCarRequestDto> getBuyCarByCarID(String id);


}
