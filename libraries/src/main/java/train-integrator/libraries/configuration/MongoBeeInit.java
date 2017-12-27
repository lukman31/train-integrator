package train-integrator.libraries.configuration;

import com.github.mongobee.Mongobee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoBeeInit {
  @Value("${spring.data.mongodb.host}")
  private String host;
  @Value("${spring.data.mongodb.port}")
  private Integer port;
  @Value("${spring.data.mongodb.database}")
  private String database;

  @Bean
  public Mongobee mongobee(){
    Mongobee runner = new Mongobee("mongodb://"+host+":"+port.toString()+"/"+database);
    runner.setDbName(database);
    runner.setChangeLogsScanPackage("train-integrator.database.migration");
    return runner;
  }
}
