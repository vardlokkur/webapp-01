package warlock.logic;

/**
 * Defines set of methods required for command.
 *
 * @see <a href="http://en.wikipedia.org/wiki/Command_pattern">Command pattern (Wikipedia)</a>
 * @see <a href="http://sourcemaking.com/design_patterns/command">Command pattern</a>
 * @author warlock
 */
public interface Command {

    /**
     * Executes the action on the receiver.
     */
    void execute();

}
