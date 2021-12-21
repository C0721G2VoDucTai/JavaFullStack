package voductai.furama_resort.model.employee;

import javax.persistence.*;
import java.util.List;
@Entity
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(targetEntity = Employee.class, mappedBy = "educationDegree")
    private List< Employee > employeeList;

    public EducationDegree() {
    }

    public EducationDegree(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
