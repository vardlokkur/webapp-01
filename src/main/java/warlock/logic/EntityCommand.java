package warlock.logic;

import java.io.Serializable;

import org.springframework.ui.Model;

import warlock.entities.Identifiable;

/**
 * Defines set of methods required for commands performing entities related tasks.
 *
 * We assume that {@link Model} is a <em>receiver</em> of the command, action performed on
 * the receiver will modify one of its attributes, which name is defined by {@link #intoAttribute(String)} method,
 * while {@link #withId} method identifies the entity which will be used for preparing action's parameters.
 *
 * @param <E> determines the entity type
 * @param <I> determines the entity's identifier type
 * @author warlock
 */
public interface EntityCommand<E extends Identifiable<I>, I extends Serializable> extends Command {

    /**
     * Defines the model's attribute name which will be modified by command.
     *
     * @param attributeName the attribute name
     * @return entity command itself
     */
    EntityCommand<E, I> intoAttribute(String attributeName);

    /**
     * Defines receiver of the command.
     *
     * @param model the model which will be used as command's receiver
     * @return entity command itself
     */
    EntityCommand<E, I> useReceiver(Model model);

    /**
     * Defines the identifier of entity which will be used for preparing action's parameters.
     *
     * @param identifier the entity's identifier
     * @return entity command itself
     */
    EntityCommand<E, I> withId(I identifier);

}
