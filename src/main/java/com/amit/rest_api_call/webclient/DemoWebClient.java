package com.amit.rest_api_call.webclient;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

//https://howtodoinjava.com/spring-webflux/webclient-get-post-example/
public class DemoWebClient {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("starting................");
        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:8082/student")
                .build();
//full url is http://localhost:8082/student/status
        Mono<String> stringMono = webClient
                .get()
                .uri("/status")
                .retrieve().bodyToMono(String.class);

        stringMono.subscribe(response -> {
            System.out.println("result is "+response);
        },
                err -> System.out.println(" error is "+err.getMessage()),
                () -> System.out.println("completed....")
        );



        System.out.println("end........................");
        Thread.sleep(5000);
    }
}
