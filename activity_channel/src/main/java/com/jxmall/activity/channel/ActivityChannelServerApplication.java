package com.jxmall.activity.channel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.jxmall.activity.channel"})
public class ActivityChannelServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivityChannelServerApplication.class, args);
	}

}
