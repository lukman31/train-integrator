package com.tiket.tix.train.integrator.entity.constant.unit.test;

import com.tiket.tix.train.integrator.entity.dao.SystemParameter;
import com.tiket.tix.train.integrator.entity.dao.SystemParameterBuilder;
import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class SystemParameterTestVariable {

  public static final String VARIABLE = "variable";
  public static final String VALUE = "value";
  public static final String DESCRIPTION = "description";
  public static final String USERNAME = "username";
  public static final Integer PAGE = 0;
  public static final int SIZE = 10;
  public static final String SIZE_STRING = "10";
  public static final Pageable PAGEABLE = new PageRequest(PAGE,SIZE);
  public static final SystemParameter SYSTEM_PARAMETER = new SystemParameterBuilder()
      .withStoreId(CommonTestVariable.STORE_ID)
      .withValue(VALUE).withDescription(DESCRIPTION).withVariable(VARIABLE)
      .withCreatedBy(USERNAME).withCreatedDate(new Date()).withUpdatedBy(USERNAME)
      .withUpdatedDate(new Date())
      .build();
  public static final String SYSTEM_PARAMETER_REQUEST = "{\"description\":\"description\",\"value\":\"value\",\"variable\":\"variable\"}";
}
