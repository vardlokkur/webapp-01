package warlock.logic.impl;

import java.io.Serializable;

import org.springframework.ui.Model;

import warlock.entities.Identifiable;
import warlock.logic.EntityCommand;

/**
 * Base class for commands operating on entities.
 *
 * @param <E> determines the entity type
 * @param <I> determines the entity's identifier type
 * @author warlock
 */
public abstract class AbstractEntityCommand<E extends Identifiable<I>, I extends Serializable> implements
                EntityCommand<E, I> {

    private transient String attributeName;

    private transient I identifier;

    private transient Model model;

    public AbstractEntityCommand() {
        super();
    }

    public AbstractEntityCommand(final Model model) {
        this();
        this.model = model;
    }

    /* (non-Javadoc)
     * @see warlock.logic.Command#execute()
     */
    public void execute() {
        model.addAttribute(attributeName, executeInternal(identifier));
    }

    protected abstract Object executeInternal(I identifier);

    public EntityCommand<E, I> intoAttribute(final String attributeName) {
        this.attributeName = attributeName;
        return this;
    }

    public EntityCommand<E, I> useReceiver(final Model model) {
        this.model = model;
        return this;
    }

    public EntityCommand<E, I> withId(final I identifier) {
        this.identifier = identifier;
        return this;
    }

}
