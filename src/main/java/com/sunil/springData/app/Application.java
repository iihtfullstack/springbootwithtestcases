package com.sunil.springData.app;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.sunil.springData")
@EntityScan(basePackages = "com.sunil.springData.model")
@EnableJpaRepositories("com.sunil.springData.repository")

public class Application extends WebMvcConfigurerAdapter {

	  public static void main(String[] args) throws Exception {
	        SpringApplication.run(Application.class, args);
	    }
}
