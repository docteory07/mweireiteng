package com.docteory07.mweireiteng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MweireitengApplication {

	public static void main(String[] args) {
		SpringApplication.run(MweireitengApplication.class, args);
	}

}
