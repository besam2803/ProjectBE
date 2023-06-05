package com.example.capstoneprojectbe.service;

import com.example.capstoneprojectbe.model.dto.RoleDto;
import com.example.capstoneprojectbe.model.response.RoleEntity;
import com.example.capstoneprojectbe.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public boolean isExisted(String id) {
        return roleRepository.existsById(id);
    }

    public RoleEntity createNewRole(RoleEntity entity) {
        RoleDto dto = RoleDto.builder()
                .roleID(entity.getRoleID())
                .roleName(entity.getRoleName())
                .build();

        return RoleEntity.fromRoleDto(roleRepository.save(dto));
    }

    public List<RoleEntity> getAllRoles() {
        return roleRepository.findAll().stream()
                .map(RoleEntity::fromRoleDto)
                .collect(Collectors.toList());
    }

    public RoleEntity updateExistedRole(RoleEntity entity) {
        RoleDto dto = roleRepository.findById(entity.getRoleID()).orElseThrow();

        dto.setRoleID(entity.getRoleID());
        dto.setRoleName(entity.getRoleName());

        return RoleEntity.fromRoleDto(roleRepository.save(dto));
    }

    public RoleEntity deleteExistedRole(String id) {
        RoleDto dto = roleRepository.findById(id).orElseThrow();
        roleRepository.deleteById(id);
        return RoleEntity.fromRoleDto(dto);
    }


    public RoleEntity getRoleByRoleID(String id) {
        return RoleEntity.fromRoleDto(roleRepository.getById(id));
    }
}
