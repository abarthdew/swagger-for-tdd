package my.project.swaggertest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SwaggertestApplication {

  public static void main(String[] args) {
    SpringApplication.run(SwaggertestApplication.class, args);
    log.info("http://localhost:7071/swagger-ui.html");
  }

}
