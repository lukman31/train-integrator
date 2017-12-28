package com.tiket.tix.train.integrator.service.impl;

import com.google.common.collect.Lists;
import com.tiket.tix.train.integrator.dao.api.SystemParameterRepository;
import com.tiket.tix.train.integrator.entity.constant.CacheKey;
import com.tiket.tix.train.integrator.entity.constant.enums.ResponseCode;
import com.tiket.tix.train.integrator.entity.dao.SystemParameter;
import com.tiket.tix.train.integrator.libraries.exception.BusinessLogicException;
import com.tiket.tix.train.integrator.service.api.SystemParameterService;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SystemParameterServiceImpl implements SystemParameterService {

  private static final String CACHE_KEY_BY_STORE_ID_AND_VARIABLE = "#storeId + '-' + #variable";
  private static final String CACHE_KEY_BY_OBJECT = "#newSystemParameter.storeId + '-' + #newSystemParameter.variable";
  private static final Logger LOGGER = LoggerFactory.getLogger(SystemParameterServiceImpl.class);

  @Autowired
  SystemParameterRepository systemParameterRepository;

  @Override
  @Cacheable(value = CacheKey.SYSTEM_PARAMETER, key = "#storeId + '-' + #page + '-' + #size")
  public Page<SystemParameter> findAll(String storeId, Integer page, Integer size) {
    Pageable pageable = new PageRequest(page,size);
    Page<SystemParameter> systemParametersPaginated = this.systemParameterRepository
        .findByStoreId(storeId, pageable);

    if(pageable == null){
      throw new BusinessLogicException(ResponseCode.DATA_NOT_EXIST.getCode(), ResponseCode.DATA_NOT_EXIST.getMessage());
    }

    LOGGER.debug("Result of System Parameter : " + storeId);

    return systemParametersPaginated;
  }

  @Override
  public SystemParameter findSystemParameterByStoreId(String storeId, String variable) {
    SystemParameter systemParameter = this.systemParameterRepository
        .findSystemParameterByStoreIdAndVariable(storeId, variable);

    LOGGER.debug("Result of System Parameter : " + storeId + " - " +  variable);

    if (systemParameter == null) {
      throw new BusinessLogicException(ResponseCode.DATA_NOT_EXIST.getCode(),
          ResponseCode.DATA_NOT_EXIST.getMessage());
    }

    return systemParameter;
  }

  private boolean checkExistSystemParameter(String storeId, String variable) {
    try {
      this.findSystemParameterByStoreId(storeId, variable);

      return true;
    } catch (BusinessLogicException be) {
      return false;
    }
  }

  @Override
  public void createSystemParameter(SystemParameter systemParameter) {
    boolean exist = this
        .checkExistSystemParameter(systemParameter.getStoreId(), systemParameter.getVariable());

    if (exist == true) {
      throw new BusinessLogicException(ResponseCode.DUPLICATE_DATA.getCode(),
          ResponseCode.DUPLICATE_DATA.getMessage());
    }

    this.systemParameterRepository.save(systemParameter);
  }

  @Override
  @CacheEvict(value = CacheKey.SYSTEM_PARAMETER, key = SystemParameterServiceImpl.CACHE_KEY_BY_OBJECT)
  public void updateSystemParameter(SystemParameter newSystemParameter) {
    SystemParameter systemParameter = this
        .findSystemParameterByStoreId(newSystemParameter.getStoreId(),
            newSystemParameter.getVariable());

    systemParameter.setValue(newSystemParameter.getValue());
    systemParameter.setDescription(newSystemParameter.getDescription());
    systemParameter.setUpdatedBy(newSystemParameter.getUpdatedBy());
    systemParameter.setUpdatedDate(new Date());

    this.systemParameterRepository.save(systemParameter);
  }

  @Override
  @CacheEvict(value = CacheKey.SYSTEM_PARAMETER, key = SystemParameterServiceImpl.CACHE_KEY_BY_STORE_ID_AND_VARIABLE)
  public void deleteByStoreIdAndVariable(String storeId, String variable) {
    this.systemParameterRepository.deleteSystemParameterByStoreIdAndVariable(storeId, variable);
  }
}
