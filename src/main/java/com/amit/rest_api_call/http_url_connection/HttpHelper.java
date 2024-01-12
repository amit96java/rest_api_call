package com.amit.rest_api_call.http_url_connection;

import com.amit.rest_api_call.dto.CreateSessionObject;
import com.amit.rest_api_call.dto.DeleteSessionObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public interface HttpHelper {

    String openSession = "https://10.127.5.137/api/restconf/operations/adtran-cloud-platform-netconf-client-service:open-session";
    String closeSession = "https://10.127.5.137/api/restconf/operations/adtran-cloud-platform-netconf-client-service:close-session";

    default String getOpenSessionUrl(String mcpIp) {
        return String.format("https://%s/api/restconf/operations/adtran-cloud-platform-netconf-client-service:open-session", mcpIp);
    }
    default HttpsURLConnection getConnection(URL url) throws IOException {
        HttpsURLConnection httpURLConnection = (HttpsURLConnection) url.openConnection();
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-Type", "application/xml");
        httpURLConnection.setRequestProperty("Authorization", "Basic "+getEncodedCredentials("ADMIN", "P@ssw0rd"));
//        httpURLConnection.setRequestProperty("Authorization", "Bearer b3e85340b919157d1b41ee8cb2360122f9133535d3814c422fab56af720bc527");
        return httpURLConnection;
    }

    default HttpURLConnection getHttpConnection(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Authorization", "Basic "+getEncodedCredentials("ADMIN", "P@ssw0rd"));
//        httpURLConnection.setRequestProperty("Authorization", "Bearer b3e85340b919157d1b41ee8cb2360122f9133535d3814c422fab56af720bc527");
        return httpURLConnection;
    }


    default CreateSessionObject getSessionObject(String sessionName) {
        CreateSessionObject object = new CreateSessionObject();
        object.oltIp = "10.11.13.9";
        object.oltPort = "830";
        object.oltUserName = "hsvroot";
        object.oltPassword = "BOSCO";
        object.sessionName = sessionName;
        return object;
    }

    default DeleteSessionObject getDeleteSessionObject(String sessionName) {
        DeleteSessionObject object = new DeleteSessionObject();
        object.sessionName = sessionName;
        return object;
    }

    default String getEncodedCredentials(String userName, String password) throws UnsupportedEncodingException {
        return Base64
                .getEncoder()
                .encodeToString((userName + ":" + password)
                        .getBytes("UTF-8"));
    }

}
