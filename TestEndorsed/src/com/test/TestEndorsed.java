package com.test;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import com.test.model.Address;
import com.test.model.Customer;
import com.test.model.PhoneNumber;

public class TestEndorsed {
 
    public static void main(String[] args) throws Exception {
        Customer customer = new Customer();
        Address address = new Address();
        address.setStreet("1 A Street");
        customer.setContactInfo(address);
        //customer.getContactInfo();
        JAXBContext jc = JAXBContext.newInstance(Customer.class, Address.class, PhoneNumber.class);
       jc.generateSchema(new SchemaOutputResolver() {
		
		@Override
		public Result createOutput(String namespaceUri, String suggestedFileName)
				throws IOException {
			suggestedFileName = "schema.xsd";
			File file = new File(suggestedFileName);
	        StreamResult result = new StreamResult(file);
	        result.setSystemId(file.toURI().toURL().toString());
	        return result;
		}
	});
        Marshaller marshaller = jc.createMarshaller();
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
       System.out.println(marshaller.getSchema());
        Schema schema = sf.newSchema(new File("schema.xsd"));
        marshaller.setSchema(schema);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(customer, System.out);
    }
 
}	