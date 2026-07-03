package com.abhisek.asep.identity.application.dto.request;

import com.abhisek.asep.identity.domain.entity.RoleType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateRoleRequest {

    @NotNull
    private RoleType roleType;

}