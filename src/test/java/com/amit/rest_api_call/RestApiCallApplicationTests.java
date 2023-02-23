package com.amit.rest_api_call;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestApiCallApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testSum() {
		Assertions.assertTrue(5==5);
	}
}
