package com.jxmall.activitie.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.jxmall.activitie"})
public class ActivitieApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivitieApplication.class, args);
	}

}
