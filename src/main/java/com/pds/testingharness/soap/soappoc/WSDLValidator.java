package com.pds.testingharness.soap.soappoc;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class WSDLValidator {

    public static boolean validateHealth (String url)  {
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                String body = response.getBody();

                if (response != null && body.contains("definition")) {
                    return true;
                }
            }
        } catch (HttpClientErrorException e) {
            System.out.println("Error");
        }

        return false;

//        URL wsdlUrl = new URL(url);
//        HttpURLConnection connection = (HttpURLConnection) wsdlUrl.openConnection();
//        connection.setRequestMethod("GET");
//        connection.setRequestProperty("Accept", "application/wsdl+xml");
//
//        int responseCode = connection.getResponseCode();
//        if (responseCode == HttpURLConnection.HTTP_OK) {
//            return true;
//        } else {
//            return false;
//        }
    }
}
