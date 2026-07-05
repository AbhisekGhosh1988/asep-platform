package com.abhisek.asep.requirements.application.service.impl;

import com.abhisek.asep.core.support.RepositorySupport;
import com.abhisek.asep.requirements.application.service.RequirementAttachmentService;
import com.abhisek.asep.requirements.application.storage.FileStorageService;
import com.abhisek.asep.requirements.domain.exception.RequirementAttachmentNotFoundException;
import com.abhisek.asep.requirements.domain.model.RequirementAttachment;
import com.abhisek.asep.requirements.domain.repository.RequirementAttachmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class RequirementAttachmentServiceImpl implements RequirementAttachmentService {

    private final RequirementAttachmentRepository repository;
    private final FileStorageService fileStorageService;

    @Override
    public RequirementAttachment upload(String requirementId, MultipartFile file, String uploadedBy) {

        String storagePath = fileStorageService.store(file);

        RequirementAttachment attachment = RequirementAttachment.builder().id(UUID.randomUUID().toString()).requirementId(requirementId).fileName(storagePath).originalFileName(file.getOriginalFilename()).contentType(file.getContentType()).fileSize(file.getSize()).storagePath(storagePath).uploadedBy(uploadedBy).uploadedAt(Instant.now()).build();

        return repository.save(attachment);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RequirementAttachment> list(String requirementId) {

        return repository.findByRequirementId(requirementId);
    }

    @Override
    @Transactional(readOnly = true)
    public Resource download(String attachmentId) {

        RequirementAttachment attachment = RepositorySupport.require(repository.findById(attachmentId), () -> new RequirementAttachmentNotFoundException("Attachment not found"));

        return fileStorageService.load(attachment.getStoragePath());
    }

    @Override
    public void delete(String attachmentId) {

        RequirementAttachment attachment = RepositorySupport.require(repository.findById(attachmentId), () -> new RequirementAttachmentNotFoundException("Attachment not found"));

        fileStorageService.delete(attachment.getStoragePath());

        repository.delete(attachmentId);
    }
}