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
    private EntityManager entityManager;

    public SimpleEmployerFetch(Model model, ApplicationContext applicationContext) {
        super(model);
        applicationContext.getAutowireCapableBeanFactory().autowireBean(this);
    }

    @Override
    protected Object executeInternal(Long identifier) {
        return entityManager.find(Employer.class, identifier);
    }

}
