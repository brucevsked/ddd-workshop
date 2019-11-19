package com.jxmall.activity.general.report;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.jxmall.activity.general.report"})
public class ActivityGeneralReportServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivityGeneralReportServerApplication.class, args);
	}

}
