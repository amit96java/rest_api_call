package com.amit.rest_api_call;

import com.amit.rest_api_call.dto.CreateSessionObject1;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApiCallApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RestApiCallApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CreateSessionObject1 object = new CreateSessionObject1();
		object.oltIp = "10.127.5.139";
		object.sessionName = "session-123";
		object.convertToXml();
	}
}
