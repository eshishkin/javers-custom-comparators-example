package org.eshishkin.javers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.javers.core.metamodel.annotation.Id;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class EntityWithStringIdentifier {
    private String firstName;
    private String familyName;
    private String data;

    @Id
    public String getSyntheticId() {
        return firstName + " " + familyName;
    }
}
