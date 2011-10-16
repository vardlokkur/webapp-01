package warlock.entities.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import warlock.entities.AbstractIdentifiable;

/**
 * Position.
 *
 * @author warlock
 */
@Entity
public class Position extends AbstractIdentifiable<Long> {

    private Employee employee;
    private Employer employer;
    private Date endDate;
    private Long id;
    private String name;
    private Date startDate;

    @OneToOne
    public Employee getEmployee() {
        return employee;
    }

    @ManyToOne
    public Employer getEmployer() {
        return employer;
    }

    @Column(name = "END_DATE")
    @Temporal(TemporalType.DATE)
    public Date getEndDate() {
        return endDate;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Column(name = "START_DATE")
    @Temporal(TemporalType.DATE)
    public Date getStartDate() {
        return startDate;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

}
