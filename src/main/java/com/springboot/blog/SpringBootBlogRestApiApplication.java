package com.springboot.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class SpringBootBlogRestApiApplication {

	@PostConstruct
	public void init(){
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+04:00"));
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBlogRestApiApplication.class, args);
	}

}
