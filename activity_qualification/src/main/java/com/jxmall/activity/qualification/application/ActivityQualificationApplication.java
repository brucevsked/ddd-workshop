package com.jxmall.activity.qualification.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.jxmall.activity.qualification"})
public class ActivityQualificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivityQualificationApplication.class, args);
	}

}
