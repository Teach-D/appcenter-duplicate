package com.example.appcenter_project.controller.announcement;


import com.example.appcenter_project.dto.AttachedFileDto;
import com.example.appcenter_project.dto.ImageLinkDto;
import com.example.appcenter_project.dto.request.announement.RequestAnnouncementDto;
import com.example.appcenter_project.dto.request.tip.RequestTipDto;
import com.example.appcenter_project.dto.response.announcement.ResponseAnnouncementDto;
import com.example.appcenter_project.dto.response.tip.ResponseTipDto;
import com.example.appcenter_project.security.CustomUserDetails;
import com.example.appcenter_project.service.announcement.AnnouncementService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/announcements")
public class AnnouncementController {

    private final AnnouncementService announcementService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> saveAnnouncement(
            @AuthenticationPrincipal CustomUserDetails user,
            @Valid @RequestPart("requestAnnouncementDto") RequestAnnouncementDto requestAnnouncementDto,
            @RequestPart(value = "files", required = false) List<MultipartFile> files) {
        announcementService.saveAnnouncement(requestAnnouncementDto, files);
        return ResponseEntity.status(CREATED).build();
    }

    // 모든 Announcement 조회
    @GetMapping
    public ResponseEntity<List<ResponseAnnouncementDto>> findAllAnnouncements() {
        return ResponseEntity.status(OK).body(announcementService.findAllAnnouncements());
    }

    // 특정 Announcement 조회
    @GetMapping("/{announcementId}")
    public ResponseEntity<ResponseAnnouncementDto> findAnnouncement(@PathVariable Long announcementId) {
        return ResponseEntity.status(OK).body(announcementService.findAnnouncement(announcementId));
    }

    // 특정 Announcement AttachedFile 조회
    @GetMapping("/{announcementId}/image")
    public ResponseEntity<List<AttachedFileDto>> findAnnouncementFile(
            @PathVariable Long announcementId,
            HttpServletRequest request) {
        try {
            List<AttachedFileDto> fileDtos = announcementService.findAttachedFileByAnnouncementId(announcementId, request);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_TYPE, "application/json")
                    .body(fileDtos);
        } catch (Exception e) {
            log.error("Error retrieving tip images: ", e);
            throw e;
        }
    }

    @PutMapping("/{announcementId}")
    public ResponseEntity<ResponseAnnouncementDto> updateAnnouncement(@RequestBody RequestAnnouncementDto requestAnnouncementDto, @PathVariable Long announcementId) {
        return ResponseEntity.status(OK).body(announcementService.updateAnnouncement(requestAnnouncementDto, announcementId));
    }

    // AttachedFile 하나 삭제
    @DeleteMapping("/{announcementId}/file/{filePath}")
    public void deleteFilePath(@PathVariable Long announcementId, @PathVariable String filePath) {
        announcementService.deleteAttachedFile(announcementId, filePath);
    }

    // 특정 Announcement 삭제
    @DeleteMapping("/{announcementId}")
    public void deleteAnnouncement(@PathVariable Long announcementId) {
        announcementService.deleteAnnouncement(announcementId);
    }
}
