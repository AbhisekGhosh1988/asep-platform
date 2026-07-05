package com.abhisek.asep.requirements.application.service;

import com.abhisek.asep.requirements.domain.model.RequirementAttachment;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RequirementAttachmentService {

    RequirementAttachment upload(String requirementId, MultipartFile file, String uploadedBy);

    List<RequirementAttachment> list(String requirementId);

    Resource download(String attachmentId);

    void delete(String attachmentId);

}