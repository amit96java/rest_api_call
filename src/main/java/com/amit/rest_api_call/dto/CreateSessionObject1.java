package com.amit.rest_api_call.dto;

import com.amit.rest_api_call.PositiveInt;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;

@XmlRootElement(name = "input")

public class CreateSessionObject1 {
    @XmlElement(name = "name")
    public String sessionName;

    @XmlElement(name = "host")
    @Valid @PositiveInt
    public String oltIp;


    public String convertToXml() throws JAXBException {
        return convertObjectToString(this);
    }

    private String convertObjectToString(CreateSessionObject1 object) throws JAXBException {
        JAXBContext contextObj = JAXBContext.newInstance(object.getClass());
        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter sw = new StringWriter();
        marshallerObj.marshal(object, sw);
        String xmlString = sw.toString();
        System.out.println("xml string is "+xmlString);
        return xmlString;
    }

    @Override
    public String toString() {
        return "CreateSessionObject1{" +
                "sessionName='" + sessionName + '\'' +
                ", oltIp='" + oltIp + '\'' +
                '}';
    }
}
