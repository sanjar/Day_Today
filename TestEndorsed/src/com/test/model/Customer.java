package com.test.model;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {
 
	@XmlElementRefs({
		@XmlElementRef(name="address",type=Address.class,required=true),
		@XmlElementRef(name="phoneNumber",type=PhoneNumber.class,required=true)
		
		
	})
    private ContactInfo contactInfo;
 
    //@XmlElementRef
    /*public ContactInfo getContactInfo() {
        return contactInfo;
    }*/	
 
    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }
 
}