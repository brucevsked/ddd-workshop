package com.jxmall.activity.benefit.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.jxmall.activity.benefit"})
public class ActivityBenefitApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivityBenefitApplication.class, args);
	}

}
