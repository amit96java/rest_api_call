package com.amit.rest_api_call;

import com.amit.rest_api_call.dto.CreateSessionObject1;

public class DemoPurpose {
    public static void main(String[] args) {
        CreateSessionObject1 object1 = new CreateSessionObject1();
        object1.oltIp = "qwer";
        object1.sessionName = "1235";

        System.out.println(object1.toString());
    }
}
