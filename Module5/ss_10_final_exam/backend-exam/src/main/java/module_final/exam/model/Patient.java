package module_final.exam.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Patient {
    @Id
    private Integer id;
    private String name;
    @OneToMany(targetEntity = Medical.class, mappedBy = "patient", fetch = FetchType.EAGER)
    List< Medical > medicalList;

    public Patient() {
    }

    public Patient(Integer id, String name) {
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

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
