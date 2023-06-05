package com.example.capstoneprojectbe.model.response;

import com.example.capstoneprojectbe.model.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    private String userID;

    private String password;

    private String fullName;

    private String phone;

    private String address;

    private String avatarUrl;

    private boolean status;

    private String roleID;

    public static UserEntity fromUserDto(UserDto dto) {
        return UserEntity.builder()
                .userID(dto.getUserID())
                .password(dto.getPassword())
                .fullName(dto.getFullName())
                .phone(dto.getPhone())
                .address(dto.getAddress())
                .avatarUrl(dto.getAvatarUrl())
                .status(dto.isStatus())
                .roleID(dto.getRoleDto().getRoleID())
                .build();
    }
}
