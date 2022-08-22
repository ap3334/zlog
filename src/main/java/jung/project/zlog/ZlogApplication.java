package jung.project.zlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ZlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZlogApplication.class, args);
    }

}
