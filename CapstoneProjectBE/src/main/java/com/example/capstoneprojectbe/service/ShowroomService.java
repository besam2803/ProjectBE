package com.example.capstoneprojectbe.service;

import com.example.capstoneprojectbe.model.dto.RoleDto;
import com.example.capstoneprojectbe.model.dto.ShowroomDto;
import com.example.capstoneprojectbe.model.response.RoleEntity;
import com.example.capstoneprojectbe.model.response.ShowroomEntity;
import com.example.capstoneprojectbe.model.response.UserEntity;
import com.example.capstoneprojectbe.repository.RoleRepository;
import com.example.capstoneprojectbe.repository.ShowroomRepository;
import com.example.capstoneprojectbe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowroomService {
    private final ShowroomRepository showroomRepository;

    private final UserRepository userRepository;

    public boolean isExisted(String id) {
        return showroomRepository.existsById(id);
    }

    public ShowroomEntity createNewShowroom(ShowroomEntity entity) {
        ShowroomDto dto = ShowroomDto.builder()
                .showroomID(entity.getShowroomID())
                .showroomName(entity.getShowroomName())
                .showroomAddress(entity.getShowroomAddress())
                .showroomPhone(entity.getShowroomPhone())
                .userDto(userRepository.findById(entity.getUserID()).orElseThrow())
                .build();

        return ShowroomEntity.fromShowroomDto(showroomRepository.save(dto));
    }


    public ShowroomEntity getShowroomByShowroomID(String id) {
        return ShowroomEntity.fromShowroomDto(showroomRepository.getById(id));
    }

    public ShowroomEntity updateExistedShowroom(ShowroomEntity entity) {
        ShowroomDto dto = showroomRepository.findById(entity.getShowroomID()).orElseThrow();

        dto.setShowroomName(entity.getShowroomName());
        dto.setShowroomAddress(entity.getShowroomAddress());
        dto.setShowroomPhone(entity.getShowroomPhone());
        dto.setUserDto(userRepository.findById(entity.getUserID()).orElseThrow());

        return ShowroomEntity.fromShowroomDto(showroomRepository.save(dto));
    }

    public ShowroomEntity deleteExistedShowroom(String id) {
        ShowroomDto dto = showroomRepository.findById(id).orElseThrow();
        showroomRepository.deleteById(id);
        return ShowroomEntity.fromShowroomDto(dto);
    }



}
