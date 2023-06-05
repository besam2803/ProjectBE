package com.example.capstoneprojectbe.model.response;

import com.example.capstoneprojectbe.model.dto.ShowroomDto;
import com.example.capstoneprojectbe.model.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowroomEntity {
    private String showroomID;

    private String showroomName;

    private String showroomAddress;

    private String showroomPhone;

    private String userID;

    public static ShowroomEntity fromShowroomDto(ShowroomDto dto) {
        return ShowroomEntity.builder()
                .showroomID(dto.getShowroomID())
                .showroomName(dto.getShowroomName())
                .showroomAddress(dto.getShowroomAddress())
                .showroomPhone(dto.getShowroomPhone())
                .userID(dto.getUserDto().getUserID())
                .build();
    }

}
