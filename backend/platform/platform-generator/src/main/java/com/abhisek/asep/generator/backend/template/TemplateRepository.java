package com.abhisek.asep.generator.backend.template;

/**
 * Loads generation templates.
 */
public interface TemplateRepository {

    /**
     * Loads a template from the template store.
     *
     * @param name template name
     * @return template
     */
    Template load(String name);

}