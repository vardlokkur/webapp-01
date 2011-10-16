package warlock.entities.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import warlock.entities.AbstractIdentifiable;

/**
 * Salary.
 *
 * @author warlock
 */
@Entity
public class Salary extends AbstractIdentifiable<Long> {

    private BigDecimal amount;

    private Employee employee;

    private Long id;

    private Integer month;

    private Date transferDate;

    private Integer year;

    public BigDecimal getAmount() {
        return amount;
    }

    @ManyToOne
    public Employee getEmployee() {
        return employee;
    }

    @Id
    public Long getId() {
        return id;
    }

    public Integer getMonth() {
        return month;
    }

    @Column(name = "TRANSFER_DATE")
    @Temporal(TemporalType.DATE)
    public Date getTransferDate() {
        return transferDate;
    }

    public Integer getYear() {
        return year;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

}
