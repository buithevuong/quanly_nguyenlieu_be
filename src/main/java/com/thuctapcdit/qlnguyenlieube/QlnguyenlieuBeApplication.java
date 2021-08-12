package com.thuctapcdit.qlnguyenlieube;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class QlnguyenlieuBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(QlnguyenlieuBeApplication.class, args);
	}

}
