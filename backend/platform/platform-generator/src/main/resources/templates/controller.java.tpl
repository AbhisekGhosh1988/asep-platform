package ${package};

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${requestMapping}")
public class ${className} {

    private final ${useCase} useCase;

    @${httpMethod}Mapping
    public ${responseType} execute(
            @RequestBody ${requestType} request) {

        return useCase.execute(request);

    }

}