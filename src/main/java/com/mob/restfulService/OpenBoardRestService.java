package com.mob.restfulService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.mob" })
public class OpenBoardRestService {
	
//	 @Autowired
//	 DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(OpenBoardRestService.class, args);
	}

}
