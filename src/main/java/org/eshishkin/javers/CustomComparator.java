package org.eshishkin.javers;

import org.javers.core.diff.changetype.PropertyChange;
import org.javers.core.diff.changetype.PropertyChangeMetadata;
import org.javers.core.diff.changetype.ValueChange;
import org.javers.core.diff.custom.CustomPropertyComparator;
import org.javers.core.metamodel.property.Property;

import java.util.Objects;
import java.util.Optional;

public class CustomComparator implements CustomPropertyComparator<String, PropertyChange> {

    private static final String EMPTY = "";

    @Override
    public Optional<PropertyChange> compare(String left, String right,
                                            PropertyChangeMetadata metadata, Property property) {
        if (equals(left, right)) {
            return Optional.empty();
        }
        return Optional.of(new ValueChange(metadata, left, right));
    }

    @Override
    public boolean equals(String a, String b) {
        return Objects.toString(a, EMPTY).equals(Objects.toString(b, EMPTY));
    }

    @Override
    public String toString(String value) {
        return value;
    }
}
