package com.example.appcenter_project.dto.response.user;

import com.example.appcenter_project.entity.user.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseUserDto {

    private String name;
    private String studentNumber;
    private String dormType;
    private String college;
    private int penalty;


    public static ResponseUserDto entityToDto(User user) {
        return ResponseUserDto.builder()
                .name(user.getName() != null ? user.getName() : "")
                .studentNumber(user.getStudentNumber())
                .dormType(user.getDormType() != null ? user.getDormType().toValue() : "")
                .college(user.getCollege() != null ? user.getCollege().toValue() : "")
                .penalty(user.getPenalty())
                .build();
    }
}
