package com.amit.rest_api_call.http_url_connection;

import com.amit.rest_api_call.dto.Book;
import com.amit.rest_api_call.helper.Converter;

import javax.net.ssl.HttpsURLConnection;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PostApi implements Converter, HttpHelper, DisableSSL {


    public void deleteSession(String sessionName) {
        try {
            URL url = new URL(closeSession);
            HttpsURLConnection httpsURLConnection = getConnection(url);
            OutputStream outputStream = httpsURLConnection.getOutputStream();
            outputStream.write(convertObjectToString(getDeleteSessionObject(sessionName)).getBytes());
            outputStream.flush();
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            println(Thread.currentThread().getName() + " "+ formatter.format(date));
            println("response  " + httpsURLConnection.getResponseMessage());
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    public void createSession(String sessionName) {
        try {
            URL url = new URL(getOpenSessionUrl("10.127.5.137"));
            HttpsURLConnection httpsURLConnection = getConnection(url);
            try(OutputStream outputStream = httpsURLConnection.getOutputStream()) {
                //below payload write
                outputStream.write(convertObjectToString(getSessionObject(sessionName)).getBytes());
                outputStream.flush();
            }
            println(Thread.currentThread().getName() + " "+ getCurrentTime());
            if(httpsURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                String text = convertInputStreamToString(httpsURLConnection.getInputStream());
                println("good response  " + text);
            } else {
                String text = convertInputStreamToString(httpsURLConnection.getErrorStream());
                println("error response  " + text);
            }
        } catch (Exception exp) {
            println("error occurred: "+sessionName+" : "+exp.getMessage() );
        }
    }

    public void createBook(String bookId) {
        try {
            URL url = new URL("http://localhost:7171");
            HttpURLConnection httpsURLConnection = getHttpConnection(url);
            try(OutputStream outputStream = httpsURLConnection.getOutputStream()) {
                //below payload write
                outputStream.write(convertObjectToJsonString(new Book(bookId, "bookName")).getBytes());
                outputStream.flush();
            }
            println(Thread.currentThread().getName() + " "+ getCurrentTime());
            if(httpsURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                String text = convertInputStreamToString(httpsURLConnection.getInputStream());
                println("good response  " + text);
            } else {
                String text = convertInputStreamToString(httpsURLConnection.getErrorStream());
                println("error response  " + text);
            }
        } catch (Exception exp) {
            exp.printStackTrace();
            println("error occurred: "+bookId+" : "+exp.getMessage() );
        }
    }

    static {
        System.out.println("starting of static block......");
        DisableSSL.disableSslVerification();
        System.out.printf("end of static block.......");
    }

}
