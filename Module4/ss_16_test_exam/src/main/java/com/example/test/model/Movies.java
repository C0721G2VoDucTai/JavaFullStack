package com.example.test.model;

import com.example.test.sequence_id_generator.CustomIdGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Table
@Entity
public class Movies implements Validator {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @GenericGenerator(
            name = "customer_seq",
            strategy = "com.example.test.sequence_id_generator.CustomIdGenerator",
            parameters = {
                    @Parameter(name = CustomIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = CustomIdGenerator.VALUE_PREFIX_PARAMETER, value = "CI-"),
                    @Parameter(name = CustomIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")})
    @Id
    private String id;
    @NotBlank(message = "Name is not empty")
    private String name;
    @NotNull
    @Column(columnDefinition = "Datetime")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
//    @DateTimeFormat(pattern = "yyyy-MM-dd)
//    private LocalDate date;
    private LocalDateTime date;
    @NotNull(message = "Quantity is not empty")
    @Min(value = 1)
    private Integer quantity;
    @ManyToOne(targetEntity = Film.class)
    private Film film;

    public Movies() {
    }

    public Movies(String id, String name, LocalDateTime date, Integer quantity, Film film) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.quantity = quantity;
        this.film = film;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", quantity=" + quantity +
                ", film=" + film +
                '}';
    }

    @Override
    public boolean supports(Class< ? > clazz) {
        return Movies.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
//        Movies movies = (Movies) target;
//        String name = movies.getName();
//        ValidationUtils.rejectIfEmpty(errors, "name", "name_duplication");
//        if (number.length()>11 || number.length()<10){
//            errors.rejectValue("number", "number.length");
//        }
//        if (!number.startsWith("0")){
//            errors.rejectValue("number", "number.startsWith");
//        }
//        if (!number.matches("(^$|[0-9]*$)")){
//            errors.rejectValue("number", "number.matches");
//        }
    }
}
