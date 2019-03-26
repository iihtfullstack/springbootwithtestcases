package com.sunil.capsule.app;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.sunil.capsule")
@EntityScan(basePackages = "com.sunil.capsule.model")
//@EnableJpaRepositories("com.sunil.capsule.repository")

public class TaskManagerApp extends WebMvcConfigurerAdapter {

	  public static void main(String[] args) throws Exception {
	        SpringApplication.run(TaskManagerApp.class, args);
	    }
}
