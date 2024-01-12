package com.amit.rest_api_call.helper;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;

public interface Converter {

    default <T> String convertObjectToString(T object) throws JAXBException {
        JAXBContext contextObj = JAXBContext.newInstance(object.getClass());
        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter sw = new StringWriter();
        marshallerObj.marshal(object, sw);
        String xmlString = sw.toString();
        System.out.println("xml string is "+xmlString);
        return xmlString;
    }

    default String convertInputStreamToString(InputStream inputStream) {
      return new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));
    }

    default String getCurrentTime() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    default void println(String str) {
        System.out.println(str);
    }

    private  <T> JSONObject convertToJSONObject(T object) throws ParseException, JsonProcessingException {
        //convert object to json
        String str = convertObjectToJsonString(object);
        //use json simple to parse
        JSONParser jsonParser = new JSONParser();
        return (JSONObject) jsonParser.parse(str);
    }

    default <T> String convertObjectToJsonString(final T object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        return object != null ? (mapper).writeValueAsString(object) : null;
    }
}
