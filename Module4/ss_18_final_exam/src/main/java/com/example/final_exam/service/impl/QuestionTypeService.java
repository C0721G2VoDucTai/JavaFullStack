package com.example.final_exam.service.impl;

import com.example.final_exam.model.QuestionType;
import com.example.final_exam.repository.IQuestionRepository;
import com.example.final_exam.repository.IQuestionTypeRepository;
import com.example.final_exam.service.IQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionTypeService implements IQuestionTypeService {
    @Autowired
    private IQuestionTypeRepository questionTypeRepository;

    @Override
    public Iterable< QuestionType > findAll() {
        return questionTypeRepository.findAll();
    }

    @Override
    public Optional< QuestionType > findById(Integer id) {
        return questionTypeRepository.findById(id);
    }

    @Override
    public void save(QuestionType questionType) {
        questionTypeRepository.save(questionType);
    }

    @Override
    public void remove(Integer id) {
        questionTypeRepository.deleteById(id);
    }
}
