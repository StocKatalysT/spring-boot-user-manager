package be.jimve.springbootusermanager.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "be.jimve.springbootusermanager.repositories") // For the wiring to be done, we need to enable JPA Repositories
@ComponentScan(basePackages = {"be.jimve.springbootusermanager.services", "be.jimve.springbootusermanager.ws"}) // We need to scan the Service package as well as the controller's.
@EntityScan(basePackages = "be.jimve.springbootusermanager.beans") // Our entities will be defined in the beans package
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
}
