package ${package};

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ${className} {

    ${dtoClass} toDto(${entityClass} entity);

    ${entityClass} toEntity(${dtoClass} dto);

}