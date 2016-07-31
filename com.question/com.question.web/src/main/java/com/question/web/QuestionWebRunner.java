package com.question.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages = "com.question.service.repo")
@EntityScan(basePackages = "com.question.model")
@SpringBootApplication
//@ComponentScan(basePackages="com.question.controller")
public class QuestionWebRunner {
	public static void main(String[] args) {
		SpringApplication.run(QuestionWebRunner.class, args);
	}
}
