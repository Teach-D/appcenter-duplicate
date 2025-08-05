package com.example.appcenter_project.dto.response.announcement;

import com.example.appcenter_project.entity.announcement.Announcement;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class ResponseAnnouncementDto {

    private Long id;
    private String title;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public static ResponseAnnouncementDto entityToDTo(Announcement announcement) {
        return ResponseAnnouncementDto.builder()
                .id(announcement.getId())
                .title(announcement.getTitle())
                .createdDate(announcement.getCreatedDate())
                .updatedDate(announcement.getModifiedDate())
                .build();
    }
}
