package org.eshishkin.javers;


import org.javers.common.exception.JaversException;
import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.core.MappingStyle;
import org.javers.core.diff.Diff;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AppTest {

    @Test
    public void string_identifiers() {
        Javers javers = JaversBuilder.javers()
                .withMappingStyle(MappingStyle.BEAN)
                .registerCustomType(String.class, new CustomComparator())
                .registerEntity(EntityWithStringIdentifier.class)
                .build();

        assertThrows(JaversException.class, () -> {
            javers.compare(
                    new EntityWithStringIdentifier("John", "Doe", ""),
                    new EntityWithStringIdentifier("John", "Doe", null)
            );
        });
    }

    @Test
    public void primitive_identifiers() {
        Javers javers = JaversBuilder.javers()
                .withMappingStyle(MappingStyle.BEAN)
                .registerCustomType(String.class, new CustomComparator())
                .registerEntity(EntityWithPrimitiveIdentifier.class)
                .build();


        Diff diff = javers.compare(
                new EntityWithPrimitiveIdentifier(1, "John", "Doe", ""),
                new EntityWithPrimitiveIdentifier(1, "John", "Doe", null)
        );

        assertFalse(diff.hasChanges());
    }
}
