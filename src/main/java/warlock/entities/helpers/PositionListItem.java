package warlock.entities.helpers;

import java.io.Serializable;

/**
 * @author warlock
 */
public class PositionListItem implements Serializable {

    private Double averageSalary;

    private String employeeName;

    private String employerName;

    private String positionName;

    public PositionListItem(String employerName, String positionName, String employeeName, Double averageSalary) {
        this.employerName = employerName;
        this.positionName = positionName;
        this.employeeName = employeeName;
        this.averageSalary = averageSalary;
    }

    public Double getAverageSalary() {
        return averageSalary;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployerName() {
        return employerName;
    }

    public String getPositionName() {
        return positionName;
    }

}
