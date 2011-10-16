package warlock.entities.domain.helpers;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import warlock.entities.AbstractIdentifiable;

@Entity
public class PositionListItemEntity extends AbstractIdentifiable<Long> {

    private BigDecimal averageSalary;

    private String employeeName;

    private String employerName;

    private Long id;

    private String positionName;

    @Column(name = "AVERAGE_SALARY")
    public BigDecimal getAverageSalary() {
        return averageSalary;
    }

    @Column(name = "EMPLOYEE_NAME")
    public String getEmployeeName() {
        return employeeName;
    }

    @Column(name = "EMPLOYER_NAME")
    public String getEmployerName() {
        return employerName;
    }

    @Id
    public Long getId() {
        return id;
    }

    @Column(name = "POSITION_NAME")
    public String getPositionName() {
        return positionName;
    }

    public void setAverageSalary(BigDecimal averageSalary) {
        this.averageSalary = averageSalary;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

}
