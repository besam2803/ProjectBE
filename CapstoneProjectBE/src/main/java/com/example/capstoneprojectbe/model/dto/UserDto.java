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
@Table(name = "tbl_user")
public class UserDto {

    @Id
    private String userID;

    private String password;

    private String fullName;

    private String phone;

    private String address;

    private String avatarUrl;

    private boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleID")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private RoleDto roleDto;



}
