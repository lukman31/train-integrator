package com.tiket.tix.train.integrator.outbound.impl;

import com.tiket.tix.train.integrator.entity.outbound.ExternalSystemParameter;
import com.tiket.tix.train.integrator.outbound.api.ExternalSystemParameterOutboundService;
import com.tiket.tix.train.integrator.libraries.configuration.ExampleEndpointService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Response;

@Service
public class ExampleOutboundServiceImpl implements
    ExternalSystemParameterOutboundService {

  @Autowired
  private ExampleEndpointService retrofitService;

  @Override
  public ExternalSystemParameter getAll() {
    try {

      Response<ExternalSystemParameter> response = this.retrofitService.getExternalSystemParameter().execute();

      return response.body();

    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }
}
