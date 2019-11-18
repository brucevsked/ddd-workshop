package com.jxmall.rule.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.jxmall.rule"})
public class ActivityRuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivityRuleApplication.class, args);
	}

}
