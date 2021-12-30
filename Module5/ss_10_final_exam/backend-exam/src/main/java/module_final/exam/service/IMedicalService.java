package module_final.exam.service;

import module_final.exam.model.Medical;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IMedicalService {
    Page< Medical > findAll(Pageable pageable);

//    Page< Medical > findAllByTitle(String title, Pageable pageable);
//
//    Page< Medical > fillAllByQuestionType(Integer questionTypeId, Pageable pageable);
//
//    Page< Medical > findAllByTwo(String title, Integer questionTypeId, Pageable pageable);

    Iterable< Medical > findAll();

    Optional< Medical > findById(Integer id);

    void save(Medical medical);

    void remove(Integer id);
}
