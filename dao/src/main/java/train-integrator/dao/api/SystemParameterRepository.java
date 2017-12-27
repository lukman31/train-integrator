package train-integrator.dao.api;

import train-integrator.entity.dao.SystemParameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SystemParameterRepository extends MongoRepository<SystemParameter, String>,
    SystemParameterRepositoryCustom {

  SystemParameter findSystemParameterByStoreIdAndVariable(String storeId, String variable);

  Page<SystemParameter> findByStoreId(String storeId, Pageable pageable);

  void deleteSystemParameterByStoreIdAndVariable(String storeId, String variable);
}
