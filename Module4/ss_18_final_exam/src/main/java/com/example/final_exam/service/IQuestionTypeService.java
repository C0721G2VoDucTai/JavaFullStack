package com.example.final_exam.service;

import com.example.final_exam.model.QuestionType;

import java.util.Optional;

public interface IQuestionTypeService {
    Iterable< QuestionType > findAll();

    Optional<QuestionType> findById(Integer id);

    void save(QuestionType questionType);

    void remove(Integer id);
}
