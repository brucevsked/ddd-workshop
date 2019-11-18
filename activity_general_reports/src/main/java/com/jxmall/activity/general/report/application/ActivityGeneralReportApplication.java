package com.jxmall.activity.general.report.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.jxmall.activity.general.report"})
public class ActivityGeneralReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivityGeneralReportApplication.class, args);
	}

}
