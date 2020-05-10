package sdh2.application;

import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import sdh2.data.User;
import sdh2.repository.UserRepository;


@SpringBootApplication
@EntityScan("sdh2.data")
@EnableJpaRepositories({"sdh2.repository"})
public class MainApp {
  @Autowired
  UserRepository repo;

  public static void main(String... args) {
    SpringApplication.run(MainApp.class, args);
  }

  @Bean
  ApplicationRunner run1() {
    return new ApplicationRunner() {
      public void run(ApplicationArguments args) throws Exception {
        long start = System.currentTimeMillis();
        int num = 1000;
        for (int i = 0; i < num; i++) {
          User user = new User();
          user.setData(genData);
          user = repo.save(user);
          if(i%100==0) System.out.print(".");
        }
        long delta = System.currentTimeMillis() - start;
        logger.info("written num={} time(msec)={}", num, delta);
      }
    };
  }

  static String genData;
  static {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 100; i++) {
      sb.append(UUID.randomUUID()).append("\n");
    }
    genData = sb.toString();
  }
  
  private static final Logger logger = LoggerFactory.getLogger(MainApp.class);
}
