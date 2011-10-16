package warlock.logic.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.joda.time.LocalDate;
import org.springframework.context.ApplicationContext;
import org.springframework.ui.Model;

import warlock.entities.domain.Employer;
import warlock.entities.helpers.PositionListItem;

/**
 * Entity fetching command using <em>JPQL Constructor Expressions</em>.
 *
 * @see <a href="http://download.oracle.com/docs/cd/E16764_01/apirefs.1111/e13046/ejb3_langref.html#ejb3_langref_constructor"></a>
 * @author warlock
 */
public class OptimizedEmployerFetch extends AbstractEntityCommand<Employer, Long> {

    @PersistenceContext
    private EntityManager entityManager;

    public OptimizedEmployerFetch(Model model, ApplicationContext applicationContext) {
        super(model);
        applicationContext.getAutowireCapableBeanFactory().autowireBean(this);
    }

    @Override
    protected Object executeInternal(Long identifier) {
        return entityManager
                        .createQuery("select new warlock.entities.helpers.PositionListItem(er.name, p.name, concat(concat(ee.lastName, ', '), ee.firstName), AVG(s.amount)) "
                                        + "from Position p left outer join p.employer er left outer join p.employee ee left outer join ee.salaries as s "
                                        + "where (er.id = ?1) and (s.transferDate >= ?2) group by er.name, p.name, concat(concat(ee.lastName, ', '), ee.firstName)",
                                        PositionListItem.class).setParameter(1, identifier)
                        .setParameter(2, LocalDate.now().minusYears(1).toDate()).getResultList();
    }

}
