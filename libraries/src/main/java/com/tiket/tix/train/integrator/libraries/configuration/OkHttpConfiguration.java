package com.tiket.tix.train.integrator.libraries.configuration;

import com.tiket.tix.train.integrator.entity.configuration.ExampleApiConfiguration;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(OkHttpClient.class)
public class OkHttpConfiguration {

  @Bean(name = "ExampleApiHttpClient")
  public OkHttpClient okHttpClient(ExampleApiConfiguration exampleApiConfiguration) {
    OkHttpClient.Builder builder = new OkHttpClient.Builder()
        .connectTimeout(exampleApiConfiguration.getConnectTimeout(), TimeUnit.MILLISECONDS)
        .readTimeout(exampleApiConfiguration.getReadTimeout(), TimeUnit.MILLISECONDS)
        .writeTimeout(exampleApiConfiguration.getReadTimeout(), TimeUnit.MILLISECONDS);
    if (exampleApiConfiguration.getProxyUse() == 1) {
      String credential = Credentials.basic(exampleApiConfiguration.getProxyUsername(),
          exampleApiConfiguration.getProxyPassword());
      java.net.Proxy proxy =
          new Proxy(Proxy.Type.HTTP, new InetSocketAddress(exampleApiConfiguration.getProxyHost(),
              exampleApiConfiguration.getProxyPort()));
      builder.proxy(proxy);
    }

    return builder.build();
  }

}
