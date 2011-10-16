package warlock.logic.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.joda.time.LocalDate;
import org.springframework.context.ApplicationContext;
import org.springframework.ui.Model;

import warlock.entities.domain.Employer;
import warlock.entities.domain.helpers.PositionListItemEntity;

/**
 * Entity fetching command using native (SQL) queries which results are mapped to dedicated entities.
 *
 * <dl>
 *     <dt>Note:</dt>
 *     <dd>
 *         Results of the native (SQL) query will be mapped to {@link PositionListItemEntity} instances.
 *         Mapping between the entity's properties and columns is defined same way as for other entities.
 *     </dd>
 * </dl>
 *
 * @author warlock
 */
public class OptimizedNativeEmployerFetch extends AbstractEntityCommand<Employer, Long> {

    @PersistenceContext
    private transient EntityManager entityManager;

    public OptimizedNativeEmployerFetch(final Model model, final ApplicationContext context) {
        super(model);
        context.getAutowireCapableBeanFactory().autowireBean(this);
    }

    @Override
    protected Object executeInternal(final Long identifier) {
        return entityManager
                        .createNativeQuery(
                                        "select P.ID as ID, ER.NAME AS EMPLOYER_NAME, P.NAME AS POSITION_NAME, EE.LAST_NAME || ', ' || EE.FIRST_NAME AS EMPLOYEE_NAME, AVG(S.AMOUNT) AS AVERAGE_SALARY "
                                                        + "from POSITION P LEFT OUTER JOIN EMPLOYER ER ON (ER.ID = P.EMPLOYER_ID) LEFT OUTER JOIN EMPLOYEE EE ON (EE.ID = P.EMPLOYEE_ID) LEFT OUTER JOIN SALARY S ON (S.EMPLOYEE_ID = EE.ID) "
                                                        + "WHERE (ER.ID = ?1) AND (S.TRANSFER_DATE >= ?2) GROUP BY P.ID, ER.NAME, P.NAME, EE.LAST_NAME || ', ' || EE.FIRST_NAME",
                                        PositionListItemEntity.class).setParameter(1, identifier)
                        .setParameter(2, LocalDate.now().minusYears(1).toDate()).getResultList();
    }

}
