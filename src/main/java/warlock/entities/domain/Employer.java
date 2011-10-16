package warlock.entities.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import warlock.entities.AbstractIdentifiable;

/**
 * Represents Employer information.
 *
 * @author warlock
 */
@Entity
public class Employer extends AbstractIdentifiable<Long> {

    private List<Employee> employees;

    private Long id;

    private String name;

    private List<Position> positions;

    /**
     * @return the list of employees
     */
    @OneToMany(mappedBy = "employer")
    public List<Employee> getEmployees() {
        return employees;
    }

    /* (non-Javadoc)
     * @see warlock.entities.Identifiable#getId()
     */
    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    /**
     * @return the employer's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the list of positions
     */
    @OneToMany(mappedBy = "employer")
    public List<Position> getPositions() {
        return positions;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

}
