package com.abhisek.asep.project.application.usecase;

public interface RemoveProjectMemberUseCase {

    void execute(String projectId, String userId);

}