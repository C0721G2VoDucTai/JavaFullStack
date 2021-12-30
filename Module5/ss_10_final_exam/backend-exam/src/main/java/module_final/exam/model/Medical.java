package module_final.exam.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class Medical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(targetEntity = Patient.class)
    private Patient patient;
    @NotBlank(message = "Start day is not blank")
    private LocalDate startDay;
    @NotBlank(message = "End day is not blank")
    private LocalDate endDay;
    @NotBlank(message = "Reason day is not blank")
    private String reason;
    @NotBlank(message = "Treatment is not blank")
    private String treatment;
    @NotBlank(message = "Doctor day is not blank")
    private String doctor;
    private String url;

    public Medical() {
    }

    public Medical(Integer id, Patient patient, LocalDate startDay, LocalDate endDay,
                   String reason, String treatment, String doctor) {
        this.id = id;
        this.patient = patient;
        this.startDay = startDay;
        this.endDay = endDay;
        this.reason = reason;
        this.treatment = treatment;
        this.doctor = doctor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }

    public LocalDate getEndDay() {
        return endDay;
    }

    public void setEndDay(LocalDate endDay) {
        this.endDay = endDay;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Medical{" +
                "id=" + id +
                ", patient=" + patient +
                ", startDay=" + startDay +
                ", endDay=" + endDay +
                ", reason='" + reason + '\'' +
                ", treatment='" + treatment + '\'' +
                ", doctor='" + doctor + '\'' +
                '}';
    }
}

