package voductai.add_log.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import voductai.add_log.model.Province;

@Repository
public interface ProvinceRepository extends CrudRepository< Province, Long> {
}
