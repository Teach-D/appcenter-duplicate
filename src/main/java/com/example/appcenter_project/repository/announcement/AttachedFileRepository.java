package com.example.appcenter_project.repository.announcement;

import com.example.appcenter_project.entity.announcement.Announcement;
import com.example.appcenter_project.entity.announcement.AttachedFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AttachedFileRepository extends JpaRepository<AttachedFile,Integer> {
    List<AttachedFile> findByAnnouncement(Announcement announcement);
    void deleteByFilePath(String filePath);

    Optional<AttachedFile> findByFilePath(String filePath);
}
