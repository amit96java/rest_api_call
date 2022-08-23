package com.amit.rest_api_call.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "input")
public class DeleteSessionObject {
    @XmlElement(name = "session-name")
    public String sessionName;
}
