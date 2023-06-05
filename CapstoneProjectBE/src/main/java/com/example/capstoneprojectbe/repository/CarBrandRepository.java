package com.example.capstoneprojectbe.repository;

import com.example.capstoneprojectbe.model.dto.CarBrandDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CarBrandRepository extends JpaRepository<CarBrandDto, String> {
}
