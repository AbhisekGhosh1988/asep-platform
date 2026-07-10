package ${package};

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ${className}
        implements ${interfaceName} {

${dependencies}

    @Override
    public ${responseType} execute(
            ${requestType} request) {

${body}

    }

}