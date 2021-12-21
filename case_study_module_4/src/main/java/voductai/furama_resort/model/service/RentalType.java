package voductai.furama_resort.model.service;

import javax.persistence.*;
import java.util.List;
@Entity
public class RentalType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(targetEntity = Services.class, mappedBy = "rentalType")
    List< Services > servicesList;
    public RentalType() {
    }

    public RentalType(Integer id, String name) {
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
