package voductai.furama_resort.model.employee;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String password;
    @OneToMany(targetEntity = Employee.class, mappedBy = "user")
    private List< Employee > employeeList;
    // Khử đệ quy (có nhiều cách)
    @ManyToMany(mappedBy = "userList", fetch = FetchType.EAGER)
    private List< Role > roleList;


    public User() {
    }

    public User(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List< Role > getRoleList() {
        return roleList;
    }

    public void setRoleList(List< Role > roleList) {
        this.roleList = roleList;
    }
}
