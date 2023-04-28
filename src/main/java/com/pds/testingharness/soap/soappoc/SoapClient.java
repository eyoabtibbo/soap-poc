package com.pds.testingharness.soap.soappoc;

import com.pds.testingharness.soap.soappoc.stub.NumberToDollars;
import com.pds.testingharness.soap.soappoc.stub.NumberToDollarsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.bind.JAXBElement;

@Service
public class SoapClient extends WebServiceGatewaySupport {

    @Autowired
    private Jaxb2Marshaller marshaller;

    private WebServiceTemplate webServiceTemplate;

    public NumberToDollarsResponse getDollarsAmount(NumberToDollars request) {
        webServiceTemplate = new WebServiceTemplate(marshaller);
        NumberToDollarsResponse response = (NumberToDollarsResponse) webServiceTemplate.marshalSendAndReceive("https://www.dataaccess.com/webservicesserver/numberconversion.wso", request);
        return response;
    }

    /*
    public NumberToDollarsResponse getDollars(String url, Object request) {
        JAXBElement response = (JAXBElement) getWebServiceTemplate().marshalSendAndReceive(url, request);
        return (NumberToDollarsResponse) response.getValue();
    } */
}
