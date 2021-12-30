package module_final.exam.repository;

import module_final.exam.model.Medical;
import org.apache.tomcat.util.http.parser.MediaTypeCache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedicalRepository extends JpaRepository< Medical, Integer > {
}
