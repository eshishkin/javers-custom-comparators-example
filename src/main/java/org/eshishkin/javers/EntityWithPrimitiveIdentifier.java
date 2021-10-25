package org.eshishkin.javers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.javers.core.metamodel.annotation.Id;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class EntityWithPrimitiveIdentifier {
    private int id;
    private String firstName;
    private String familyName;
    private String data;

    @Id
    public int getId() {
        return id;
    }
}
