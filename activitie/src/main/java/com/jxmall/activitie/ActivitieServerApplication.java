package com.jxmall.activitie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.jxmall.activitie"})
public class ActivitieServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivitieServerApplication.class, args);
	}

}
