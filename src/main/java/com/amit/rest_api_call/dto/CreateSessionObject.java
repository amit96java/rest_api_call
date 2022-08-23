package com.amit.rest_api_call.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "input")
public class CreateSessionObject {
   @XmlElement(name = "name")
    public String sessionName;
   @XmlElement(name = "host")
    public String oltIp;
   @XmlElement(name = "port")
    public String oltPort;
   @XmlElement(name = "username")
    public String oltUserName;
   @XmlElement(name = "password")
    public String oltPassword;
}
