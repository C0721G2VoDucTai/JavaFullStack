package voductai.furama_resort.repository.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import voductai.furama_resort.model.contract.AttachService;
@Repository
public interface IAttachServiceRepository extends JpaRepository< AttachService, Integer > {
}
