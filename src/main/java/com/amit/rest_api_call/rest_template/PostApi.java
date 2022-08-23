package com.amit.rest_api_call.rest_template;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class PostApi {

    static String openSession = "https://10.127.5.139/api/restconf/operations/adtran-cloud-platform-netconf-client-service:open-session";

    private static void useRestTemplate() throws URISyntaxException {
        try {
            RestTemplate restTemplate = new RestTemplate();
            URI uri = new URI(openSession);

            ResponseEntity<String> result = restTemplate.postForEntity(uri, createXml(), String.class);

            //Verify request succeed
            System.out.println("result is " + result);
        } catch (Exception exp) {
            exp.printStackTrace();
        }

    }

    private static String createXml() {
        return "<input>\n" +
                "    <name>mock-device-11</name>\n" +
                "    <host>10.127.2.98</host>\n" +
                "    <port>830</port>\n" +
                "    <username>hsvroot</username>\n" +
                "    <password>BOSCO</password>\n" +
                "</input>";
    }
}
