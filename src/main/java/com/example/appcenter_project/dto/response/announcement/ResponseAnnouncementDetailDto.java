package com.example.appcenter_project.dto.response.announcement;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class ResponseAnnouncementDetailDto {

    private Long id;
    private String title;
    private String writer;
    private String content;
    private int viewCount;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
