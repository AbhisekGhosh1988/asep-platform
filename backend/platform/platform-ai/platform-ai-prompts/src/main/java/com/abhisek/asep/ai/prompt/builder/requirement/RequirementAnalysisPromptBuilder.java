package com.abhisek.asep.ai.prompt.builder.requirement;

import com.abhisek.asep.ai.prompt.builder.AbstractPromptBuilder;
import com.abhisek.asep.ai.prompt.context.PromptContext;
import com.abhisek.asep.ai.prompt.template.PromptTemplate;
import com.abhisek.asep.ai.prompt.util.PromptUtils;
import org.springframework.stereotype.Component;

@Component
public class RequirementAnalysisPromptBuilder
        extends AbstractPromptBuilder<PromptContext> {

    @Override
    protected PromptTemplate createPrompt(PromptContext context) {

        String systemPrompt = """
                You are a Senior Enterprise Solution Architect.
                
                Analyse the given software requirement.
                
                Evaluate:
                
                1. Completeness
                2. Ambiguity
                3. Business Rules
                4. Acceptance Criteria
                5. Security
                6. Performance
                7. Scalability
                8. Reliability
                9. Risks
                10. Missing Constraints
                
                Return ONLY valid JSON.
                
                Do not explain anything outside JSON.
                """;

        String userPrompt = """
                Requirement
                
                Title:
                {{title}}
                
                Type:
                {{type}}
                
                Priority:
                {{priority}}
                
                Complexity:
                {{complexity}}
                
                Description:
                
                {{description}}
                
                Return JSON in the following format:
                
                {
                  "qualityScore":95,
                  "issues":[
                    {
                      "type":"",
                      "severity":"",
                      "title":"",
                      "description":""
                    }
                  ],
                  "suggestions":[
                    {
                      "title":"",
                      "description":""
                    }
                  ]
                }
                """;

        userPrompt = PromptUtils.replace(userPrompt, RequirementPromptVariables.TITLE, context.get(RequirementPromptVariables.TITLE));

        userPrompt = PromptUtils.replace(userPrompt, RequirementPromptVariables.TYPE, context.get(RequirementPromptVariables.TYPE));

        userPrompt = PromptUtils.replace(userPrompt, RequirementPromptVariables.PRIORITY, context.get(RequirementPromptVariables.PRIORITY));

        userPrompt = PromptUtils.replace(userPrompt, RequirementPromptVariables.COMPLEXITY, context.get(RequirementPromptVariables.COMPLEXITY));

        userPrompt = PromptUtils.replace(userPrompt, RequirementPromptVariables.DESCRIPTION, context.get(RequirementPromptVariables.DESCRIPTION));

        return PromptTemplate.builder().systemPrompt(systemPrompt).userPrompt(userPrompt).build();
    }
}