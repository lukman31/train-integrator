package train-integrator.libraries.configuration;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import train-integrator.entity.configuration.ExampleApiConfiguration;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
@ConditionalOnClass(Retrofit.class)
public class RetrofitConfiguration {

  @Bean(name = "ExampleApiRetrofit")
  public Retrofit exampleApi(ExampleApiConfiguration exampleApiConfiguration,
      @Qualifier("ExampleApiHttpClient") OkHttpClient okHttpClient) {
    Retrofit.Builder builder = new Retrofit.Builder();
    if (okHttpClient != null) {
      builder.client(okHttpClient);
    }
    builder.baseUrl(exampleApiConfiguration.getHost());
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS, true);
    builder.addConverterFactory(JacksonConverterFactory.create(objectMapper));

    return builder.build();
  }

  @Bean
  public ExampleEndpointService exampleApiService(
      @Qualifier("ExampleApiRetrofit") Retrofit retrofit) {
    return retrofit.create(ExampleEndpointService.class);
  }
}