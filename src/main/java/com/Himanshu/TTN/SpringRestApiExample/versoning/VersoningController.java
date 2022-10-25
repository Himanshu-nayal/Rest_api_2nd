package com.Himanshu.TTN.SpringRestApiExample.versoning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class VersoningController {


    @RequestMapping(path = "/v1/person", produces = "application/json")
    public PersonV1 personV1() {
        return new PersonV1("himanshu nayal");
    }


    @GetMapping(path = "/v2/person", produces = "application/json")
    public PersonV2 personV2() {
        return new PersonV2(new Name("Himanshu", "nayal"));
    }


    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getUsingParams() {
        return new PersonV1("To The new");
    }

    @GetMapping(path = "/v1/person", params = "version=2")
    public PersonV2 getUser2Params() {
        return new PersonV2(new Name("happy", "diwali"));
    }
    //custom header versioning

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getUsingRequestHeader() {
        return new PersonV1("To The new");
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getSecondUsingRequestHeader() {
        return new PersonV2(new Name("To The new", "Happy diwali"));
    }

    //media type versioning
    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getUsingAcceptHeader() {
        return new PersonV1("To The new");
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getUsingSecondAcceptHeader() {
        return new PersonV2(new Name("welcome to", "Spring rest api"));


    }
}
