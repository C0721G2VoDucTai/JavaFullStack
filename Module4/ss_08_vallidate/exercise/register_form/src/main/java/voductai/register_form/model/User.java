package voductai.register_form.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import voductai.register_form.util.PhoneConstraint;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Validation;
import javax.validation.constraints.*;

@Entity
public class User implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank (message = "Name is not empty")
    @Size(min = 5, max = 45, message = "Length of name is 5-45")
    private String firstName;
    @NotBlank (message = "Name is not empty")
    @Size(min = 5, max = 45, message = "Length of name is 5-45")
    private String lastName;
    @PhoneConstraint (message = "Phone is wrong format")
    private String phone;
    @NotNull
    @Min(18)  @Max(100)
    private Integer age;
    private String email;

    public User() {

    }

    public User(@NotEmpty(message = "First name is not empty")
                @Size(min = 5, max = 45, message = "Length of name is 5-45") String firstName,
                @NotEmpty(message = "Last name is not empty")
                @Size(min = 5, max = 45, message = "Length of name is 5-45") String lastName,
                @NotEmpty(message = "Phone is not empty") String phone,
                @NotEmpty(message = "Age is not empty") @Min(18) Integer age,
                @NotEmpty(message = "Email is not empty")
//                @Email(message = "Wrong format of email")
                        String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class< ? > clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (!user.email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+.[a-z]{2,6}$")) {
            errors.rejectValue("email", "email.invalidFormat");
        }
    }
}
