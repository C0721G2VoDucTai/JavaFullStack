package com.example.final_exam.service.impl;

import com.example.final_exam.model.Question;
import com.example.final_exam.repository.IQuestionRepository;
import com.example.final_exam.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class QuestionService implements IQuestionService {
    @Autowired
    private IQuestionRepository questionRepository;


    @Override
    public Page< Question > findAll(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    @Override
    public Page< Question > findAllByTitle(String title, Pageable pageable) {
        return questionRepository.findAllByTitleContaining(title,pageable);
    }

    @Override
    public Page< Question > fillAllByQuestionType(Integer questionTypeId, Pageable pageable) {
        return questionRepository.findAllByQuestionType_Id(questionTypeId,pageable);
    }

    @Override
    public Page< Question > findAllByTwo(String title, Integer questionTypeId, Pageable pageable) {
        return questionRepository.findAllByTitleAndQuestionTypeId(title,questionTypeId,pageable);
    }

    @Override

    public Iterable< Question > findAll() {
        return questionRepository.findAll();
    }


    @Override
    public Optional< Question > findById(Integer id) {
        return questionRepository.findById(id);
    }

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void remove(Integer id) {
        questionRepository.deleteById(id);
    }
}
