package ${package};

import ${entityPackage}.${entityClass};

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ${repositoryName}
        extends JpaRepository<${entityClass}, ${idType}> {

}