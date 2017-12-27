package train-integrator.libraries.configuration;

import train-integrator.entity.outbound.ExternalSystemParameter;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ExampleEndpointService {
  @GET("/mock")
  Call<ExternalSystemParameter> getExternalSystemParameter();
}
