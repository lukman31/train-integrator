package com.tiket.tix.train.integrator.service.api;

import com.tiket.tix.train.integrator.entity.dao.SystemParameter;
import java.util.List;
import org.springframework.data.domain.Page;

public interface SystemParameterService {

  Page<SystemParameter> findAll(String storeId, Integer page, Integer size);

  SystemParameter findSystemParameterByStoreId(String storeId, String variable);

  void createSystemParameter(SystemParameter systemParameter);

  void updateSystemParameter(SystemParameter systemParameter);

  void deleteByStoreIdAndVariable(String storeId, String variable);
}
