package com.example.appcenter_project.dto.response.calender;

import com.example.appcenter_project.entity.calender.Calender;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class ResponseCalenderDto {

    private LocalDate startDate;
    private LocalDate endDate;
    private String title;
    private String link;

    public static ResponseCalenderDto entityToDto(Calender calender) {
        return ResponseCalenderDto.builder()
                .startDate(calender.getStartDate().toLocalDate())
                .endDate(calender.getEndDate().toLocalDate())
                .title(String.valueOf(calender.getTitle()))
                .link(calender.getLink())
                .build();
    }
}
