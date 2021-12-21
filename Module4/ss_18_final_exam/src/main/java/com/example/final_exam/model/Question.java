package com.example.final_exam.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Title is not empty")
    private String title;
    @NotBlank(message = "Question is not empty")
    private String questions;
    private String answer;
    @ManyToOne(targetEntity = QuestionType.class)
    private QuestionType questionType;
    private LocalDate date;
    private Boolean status;

    public Question() {
    }

    public Question(Integer id, String title, String questions, String answer, QuestionType questionType,
                    LocalDate date, Boolean status) {
        this.id = id;
        this.title = title;
        this.questions = questions;
        this.answer = answer;
        this.questionType = questionType;
        this.date = date;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String question) {
        this.questions = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", question='" + questions + '\'' +
                ", answer='" + answer + '\'' +
                ", questionType=" + questionType +
                ", date=" + date +
                ", status=" + status +
                '}';
    }
}
