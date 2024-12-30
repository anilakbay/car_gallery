package com.anilakbay.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = { "com.anilakbay" })
@EntityScan(basePackages = { "com.anilakbay" })
@EnableJpaRepositories(basePackages = { "com.anilakbay" })
@SpringBootApplication
public class CarGalleryStarter {

	public static void main(String[] args) {
		SpringApplication.run(CarGalleryStarter.class, args);
	}

}
