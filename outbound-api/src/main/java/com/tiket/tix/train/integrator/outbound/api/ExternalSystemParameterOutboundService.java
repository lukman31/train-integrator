package com.tiket.tix.train.integrator.outbound.api;

import com.tiket.tix.train.integrator.entity.outbound.ExternalSystemParameter;
import org.springframework.stereotype.Service;

@Service
public interface ExternalSystemParameterOutboundService {
  ExternalSystemParameter getAll();
}
