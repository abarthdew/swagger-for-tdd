package my.project.swaggertest.config;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ValueInjection {

  private String driverClassName;
  private String url;
  private String username;
  private String password;
}
