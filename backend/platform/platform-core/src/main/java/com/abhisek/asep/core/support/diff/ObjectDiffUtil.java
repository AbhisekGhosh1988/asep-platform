package com.abhisek.asep.core.support.diff;

import java.lang.reflect.Field;
import java.util.Objects;

public final class ObjectDiffUtil {

    private ObjectDiffUtil() {
    }

    public static DiffResult compare(Object oldObject, Object newObject) {

        DiffResult result = new DiffResult();

        if (oldObject == null || newObject == null) {
            return result;
        }

        Class<?> type = oldObject.getClass();

        for (Field field : type.getDeclaredFields()) {

            field.setAccessible(true);

            try {

                Object oldValue = field.get(oldObject);
                Object newValue = field.get(newObject);

                if (!Objects.equals(oldValue, newValue)) {

                    result.addDifference(

                            new FieldDifference(field.getName(), oldValue, newValue));

                }

            } catch (IllegalAccessException ignored) {
            }

        }

        return result;
    }
}