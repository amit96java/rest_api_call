package com.amit.rest_api_call.http_url_connection;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int threadCount = 10;
        ExecutorService service = Executors.newFixedThreadPool(threadCount);
        PostApi psmService = new PostApi();
//        IntStream.range(0,threadCount).forEach(num -> service.execute(() -> psmService.createSession(String.valueOf(num))));
//        IntStream.range(0,threadCount).forEach(num -> service.execute(() -> psmService.deleteSession(String.valueOf(num))));

        IntStream.range(0,threadCount).forEach(num -> service.execute(() -> psmService.createBook(String.valueOf(num))));

        service.shutdown();

    }




}
