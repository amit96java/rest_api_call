package com.amit.rest_api_call;

import com.amit.rest_api_call.dto.CreateSessionObject1;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping(value = "")
public class RestApiCallApplication /*implements CommandLineRunner*/ {

	public static void main(String[] args) {
		SpringApplication.run(RestApiCallApplication.class, args);
	}

//	@Override
	public void run(String... args) throws Exception {
		CreateSessionObject1 object = new CreateSessionObject1();
		object.oltIp = "10.127.5.139";
		object.sessionName = "session-123";
		object.convertToXml();
	}

	@GetMapping
	public String ping() {
		return "Hello";
	}
}
