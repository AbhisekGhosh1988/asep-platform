package com.abhisek.asep.project.application.service;

import com.abhisek.asep.project.application.dto.request.AddProjectMemberRequest;
import com.abhisek.asep.project.application.dto.response.ProjectMemberResponse;

import java.util.List;

public interface ProjectMemberService {

    ProjectMemberResponse addMember(
            String projectId,
            AddProjectMemberRequest request);

    List<ProjectMemberResponse> getMembers(
            String projectId);

    void removeMember(
            String projectId,
            String userId);

}