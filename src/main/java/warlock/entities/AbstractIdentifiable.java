package warlock.entities;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Base class for identifiable entities.
 *
 * @param <T> determines the type of entity's identifier
 * @author warlock
 */
public abstract class AbstractIdentifiable<T extends Serializable> implements Identifiable<T>, Serializable {

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId()).toHashCode();
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean equals(final Object object) {
        boolean result = (this == object);
        if (!result && (null != object) && (getClass() == object.getClass())) {
            final Identifiable other = (Identifiable) object;
            result = new EqualsBuilder().appendSuper(null != other.getId()).append(getId(), other.getId()).isEquals();
        }
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", getId()).toString();
    }

}
