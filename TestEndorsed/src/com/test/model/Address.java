package com.test.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="address")
public class Address extends ContactInfo {
 
	@XmlElement(required=false)
    private String street;
 
   /* public String getStreet() {
        return street;
    }*/
 
    public void setStreet(String street) {
        this.street = street;
    }
 
}