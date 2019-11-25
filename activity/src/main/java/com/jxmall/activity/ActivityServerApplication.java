package com.jxmall.activity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.jxmall.activity"})
public class ActivityServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivityServerApplication.class, args);
	}

}
