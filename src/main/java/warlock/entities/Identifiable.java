package warlock.entities;

import java.io.Serializable;

/**
 * Defines minimal set of methods for operating on identifiable entities.
 *
 * @param <T> determines the type of entity's identifier
 * @author warlock
 */
public interface Identifiable<T extends Serializable> {

    /**
     * @return the entity's identifier
     */
    T getId();

    /**
     * Sets the entity's identifier.
     *
     * @param identifier the identifier to set
     */
    void setId(T identifier);

}
