package com.abhisek.asep.core.application.facade;

/**
 * Base implementation for CRUD facades.
 *
 * Business modules can extend this class if needed.
 */
public abstract class AbstractCrudFacade<
        ID,
        CREATE,
        UPDATE,
        RESPONSE,
        SUMMARY>
        implements CrudFacade<
        ID,
        CREATE,
        UPDATE,
        RESPONSE,
        SUMMARY> {
}