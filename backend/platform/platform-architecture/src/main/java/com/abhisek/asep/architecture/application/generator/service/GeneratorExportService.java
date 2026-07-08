package com.abhisek.asep.architecture.application.generator.service;

import com.abhisek.asep.architecture.application.generator.model.ExportProjectModel;

public interface GeneratorExportService {

    ExportProjectModel exportProject(
            String projectId);

}