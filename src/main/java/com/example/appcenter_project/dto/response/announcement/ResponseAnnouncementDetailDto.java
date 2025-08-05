package com.example.appcenter_project.dto.response.announcement;

import com.example.appcenter_project.entity.announcement.Announcement;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
public class ResponseAnnouncementDetailDto {

    private Long id;
    private String title;
    private String writer;
    private String content;
    private int viewCount;
    private LocalDate createdDate;
    private LocalDate updatedDate;

    public static ResponseAnnouncementDetailDto entityToDto(Announcement announcement) {
        return ResponseAnnouncementDetailDto.builder()
                .id(announcement.getId())
                .title(announcement.getTitle())
                .writer(announcement.getWriter())
                .content(announcement.getContent())
                .viewCount(announcement.getViewCount())
                .createdDate(announcement.getCreatedDate().toLocalDate())
                .updatedDate(announcement.getModifiedDate().toLocalDate())
                .build();
    }
}
