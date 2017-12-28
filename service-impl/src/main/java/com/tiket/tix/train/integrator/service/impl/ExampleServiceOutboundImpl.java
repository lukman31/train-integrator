package com.tiket.tix.train.integrator.service.impl;

import com.tiket.tix.train.integrator.entity.outbound.ExternalSystemParameter;
import com.tiket.tix.train.integrator.outbound.api.ExternalSystemParameterOutboundService;
import com.tiket.tix.train.integrator.service.api.ExternalSystemParameterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleServiceOutboundImpl implements ExternalSystemParameterService{
  @Autowired
  private ExternalSystemParameterOutboundService externalSystemParameterOutboundService;

  private static Logger LOGGER = LoggerFactory.getLogger(ExampleServiceOutboundImpl.class);

  public ExternalSystemParameter getAll(){
    ExternalSystemParameter externalSystemParameter = this.externalSystemParameterOutboundService.getAll();
    LOGGER.debug("Result of System Parameter : " + externalSystemParameter.toString());
    return externalSystemParameter;
  }
}
