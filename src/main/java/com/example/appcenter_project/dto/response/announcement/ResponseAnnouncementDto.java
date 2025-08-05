package com.example.appcenter_project.dto.response.announcement;

import com.example.appcenter_project.entity.announcement.Announcement;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Schema(description = "공지사항 목록 응답 DTO")
@Builder
@Getter
public class ResponseAnnouncementDto {

    @Schema(description = "공지사항 ID", example = "1")
    private Long id;

    @Schema(description = "공지사항 제목", example = "기숙사 공지사항")
    private String title;

    @Schema(description = "생성일", example = "2025-08-05")
    private LocalDate createdDate;

    @Schema(description = "수정일", example = "2025-08-05")
    private LocalDate updatedDate;

    @Schema(description = "긴급", example = "true")
    private boolean isEmergency;

    public static ResponseAnnouncementDto entityToDTo(Announcement announcement) {
        return ResponseAnnouncementDto.builder()
                .id(announcement.getId())
                .title(announcement.getTitle())
                .createdDate(announcement.getCreatedDate().toLocalDate())
                .updatedDate(announcement.getModifiedDate().toLocalDate())
                .isEmergency(announcement.isEmergency())
                .build();
    }
}
