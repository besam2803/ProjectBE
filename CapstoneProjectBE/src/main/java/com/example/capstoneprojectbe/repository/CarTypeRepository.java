package com.example.capstoneprojectbe.repository;

import com.example.capstoneprojectbe.model.dto.CarTypeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarTypeRepository extends JpaRepository<CarTypeDto, String> {

}
