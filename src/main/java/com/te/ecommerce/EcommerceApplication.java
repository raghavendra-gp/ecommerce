package com.te.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.te.ecommerce.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);

//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		AppConfig bean = context.getBean(AppConfig.class);
//		
//		bean.passwordEncoder();
//		context.close();
//		SpringApplication.run(AppConfig.class, args);
	}
}