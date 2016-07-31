package com.question.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={ "com.question.service.repo"})
public class ApplicationConfig {

}
