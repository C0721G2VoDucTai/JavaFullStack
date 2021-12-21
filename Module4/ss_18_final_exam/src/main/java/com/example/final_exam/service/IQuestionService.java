package com.example.final_exam.service;

import com.example.final_exam.model.Question;
import com.example.final_exam.model.QuestionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IQuestionService {
    Page<Question> findAll(Pageable pageable);
    Page<Question> findAllByTitle(String title, Pageable pageable);
    Page<Question> fillAllByQuestionType(Integer questionTypeId, Pageable pageable);
    Page< Question > findAllByTwo(String title,Integer questionTypeId,Pageable pageable);
    Iterable< Question > findAll();

    Optional<Question> findById(Integer id);

    void save(Question question);

    void remove(Integer id);
}
