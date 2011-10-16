package warlock.logic.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.ApplicationContext;
import org.springframework.ui.Model;

import warlock.entities.domain.Employer;

/**
 * Entity fetching command using simple call to {@link EntityManager#find(Class, Object)} method.
 *
 * @author warlock
 */
public class SimpleEmployerFetch extends AbstractEntityCommand<Employer, Long> {

    @PersistenceContext
    private transient EntityManager entityManager;

    public SimpleEmployerFetch(final Model model, final ApplicationContext context) {
        super(model);
        context.getAutowireCapableBeanFactory().autowireBean(this);
    }

    @Override
    protected Object executeInternal(final Long identifier) {
        return entityManager.find(Employer.class, identifier);
    }

}
