package com.example.final_exam.repository;

import com.example.final_exam.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionRepository extends JpaRepository< Question, Integer > {

    Page< Question > findAllByQuestionType_Id(@Param("questionTypeId") Integer questionTypeId, Pageable pageable);

    Page< Question > findAllByTitleContaining(@Param("title") String title, Pageable pageable);
    Page< Question > findAllByTitleAndQuestionTypeId(@Param("title") String title,@Param("questionTypeId") Integer questionTypeId,
                                                      Pageable pageable);


}
