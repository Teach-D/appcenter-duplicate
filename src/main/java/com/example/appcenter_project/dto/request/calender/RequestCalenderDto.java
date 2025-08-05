package com.example.appcenter_project.dto.request.calender;

import com.example.appcenter_project.entity.calender.Calender;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class RequestCalenderDto {

    private String startDate;
    private String endDate;
    private String title;
    private String link;

    public static Calender dtoToEntity(RequestCalenderDto requestCalenderDto) {
        return Calender.builder()
                .startDate(LocalDate.parse(requestCalenderDto.getStartDate()))
                .endDate(LocalDate.parse(requestCalenderDto.getEndDate()))
                .title(requestCalenderDto.getTitle())
                .link(requestCalenderDto.getLink())
                .build();
    }
}
