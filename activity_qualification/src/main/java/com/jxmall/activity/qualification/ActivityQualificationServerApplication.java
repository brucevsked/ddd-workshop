package com.jxmall.activity.qualification.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.jxmall.activity.qualification"})
public class ActivityQualificationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivityQualificationServerApplication.class, args);
	}

}
