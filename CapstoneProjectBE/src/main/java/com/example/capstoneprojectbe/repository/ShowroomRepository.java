package com.example.capstoneprojectbe.repository;

import com.example.capstoneprojectbe.model.dto.ShowroomDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ShowroomRepository extends JpaRepository<ShowroomDto,String> {
    
}
