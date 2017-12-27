package train-integrator.outbound.api;

import train-integrator.entity.outbound.ExternalSystemParameter;
import org.springframework.stereotype.Service;

@Service
public interface ExternalSystemParameterOutboundService {
  ExternalSystemParameter getAll();
}
