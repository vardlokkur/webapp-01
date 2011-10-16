package warlock.entities.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.joda.time.LocalDate;

import warlock.entities.AbstractIdentifiable;

/**
 * Represents Employee information.
 *
 * @author warlock
 */
@Entity
public class Employee extends AbstractIdentifiable<Long> {

    private Date birthDate;

    private Employer employer;

    private String firstName;

    private Long id;

    private String lastName;

    private Position position;

    private List<Salary> salaries;

    /**
     * @return the employee's birth date
     */
    @Column(name = "BIRTH_DATE")
    @Temporal(TemporalType.DATE)
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * @return the employer
     */
    @ManyToOne
    public Employer getEmployer() {
        return employer;
    }

    /**
     * @return the employee's first name
     */
    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    /* (non-Javadoc)
     * @see warlock.entities.Identifiable#getId()
     */
    @Id
    public Long getId() {
        return id;
    }

    /**
     * @return the average salary for the last year
     */
    public BigDecimal getAverageSalary() {
        Date dateBarrier = LocalDate.now().minusYears(1).toDate();
        BigDecimal result = BigDecimal.ZERO;
        int salaryCount = 0;
        for (Salary salary : salaries) {
            if (dateBarrier.after(salary.getTransferDate())) {
                break;
            }
            result = result.add(salary.getAmount());
            salaryCount++;
        }
        if (salaryCount > 0) {
            result = result.divide(new BigDecimal(salaryCount), 2, RoundingMode.HALF_UP);
        }
        return result;
    }

    /**
     * @return the employee's last name
     */
    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the employee's position
     */
    @OneToOne(mappedBy = "employee")
    public Position getPosition() {
        return position;
    }

    /**
     * @return the employee's salaries (ordered by transfer date, descending)
     */
    @OneToMany(mappedBy = "employee")
    @OrderBy("transferDate DESC")
    public List<Salary> getSalaries() {
        return salaries;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setSalaries(List<Salary> salaries) {
        this.salaries = salaries;
    }

}
