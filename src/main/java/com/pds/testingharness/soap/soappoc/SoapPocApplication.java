package com.pds.testingharness.soap.soappoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.addressing.client.ActionCallback;

@SpringBootApplication
public class SoapPocApplication {

	@Autowired
	private WSDLValidator wsdlValidator;

	public static void main(String[] args) {
		SpringApplication.run(SoapPocApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void validateWsdl() {
		String url = "https://www.dataaccess.com/webservicesserver/numberconversion.wso?WSDL";
		boolean validWsdl = wsdlValidator.validateHealth(url);

		if (validWsdl) {
			System.out.println("Status (200) and Valid WSDL File");
		} else {
			System.out.println("Invalid WSDL file");
		}
	}

//	@Bean
//	public WebServiceTemplate webServiceTemplate() {
//		return new WebServiceTemplate();
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		String url = "https://www.dataaccess.com/webservicesserver/numberconversion.wso?WSDL";
//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
//		HttpStatus status = response.getStatusCode(); //getHeaders().getContentType().toString();
//
//		if (status == HttpStatus.OK) {
//			System.out.println("Status is Valid (200)");
//			String responseBody = response.getBody();
//			if (responseBody != null && responseBody.contains("definitions")) {
//				System.out.println("Valid WSDL");
//			} else {
//				System.out.println("Not WSDL File");
//			}
//		} else {
//			System.out.println("Invalid Status. Connection to URL was unavailable");
//		}
//	}

}
