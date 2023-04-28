package com.pds.testingharness.soap.soappoc.controller;

import com.pds.testingharness.soap.soappoc.SoapClient;
import com.pds.testingharness.soap.soappoc.stub.NumberToDollars;
import com.pds.testingharness.soap.soappoc.stub.NumberToDollarsResponse;
import com.pds.testingharness.soap.soappoc.stub.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/getDollars")
public class NumberToDollarsController {

    @Autowired
    private SoapClient soapClient;

    @GetMapping
    public NumberToDollarsResponse invokeSoapClient(@RequestBody NumberToDollars request) {
        return soapClient.getDollarsAmount(request);
    }

    /*
    @GetMapping
    public NumberToDollars getResponseFromRequest(@RequestParam BigDecimal number) {
        ObjectFactory objectFactory = new ObjectFactory();
        NumberToDollars type = new NumberToDollars();
        type.setDNum(number);

        NumberToDollarsResponse response = soapClient.getDollars("https://www.dataaccess.com/webservicesserver/numberconversion.wso", objectFactory.createNumberToDollars());
        return response.getNumberToDollarsResult();
    } */
}
