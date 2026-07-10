package com.abhisek.asep.generator.compiler.resolver;

import com.abhisek.asep.generator.ir.model.AggregateIR;
import com.abhisek.asep.generator.ir.model.DomainServiceIR;
import com.abhisek.asep.generator.ir.model.MapperIR;
import com.abhisek.asep.generator.ir.model.RepositoryIR;
import com.abhisek.asep.generator.ir.model.UseCaseIR;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DefaultUseCaseDependencyResolver implements UseCaseDependencyResolver {

    @Override
    public void resolve(AggregateIR aggregate) {

        RepositoryIR repository = aggregate.getRepositories().stream().findFirst().orElse(null);

        MapperIR mapper = aggregate.getMappers().stream().findFirst().orElse(null);

        DomainServiceIR domainService = aggregate.getDomainServices().stream().findFirst().orElse(null);

        for (UseCaseIR useCase : aggregate.getUseCases()) {

            useCase.setRepository(repository);

            useCase.setMapper(mapper);

            useCase.setDomainService(domainService);

            log.debug("Resolved dependencies for {}", useCase.getName());

        }

    }

}