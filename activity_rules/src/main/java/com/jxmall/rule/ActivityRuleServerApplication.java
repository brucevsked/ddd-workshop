package com.jxmall.rule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.jxmall.rule"})
public class ActivityRuleServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivityRuleServerApplication.class, args);
	}

}
