package com.abhisek.asep.architecture.application.design.apicontract.ai.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiContractDiscoveryResponse {

    @Builder.Default
    private List<ApiContractAI> apiContracts =
            new ArrayList<>();

}