package com.Himanshu.TTN.SpringRestApiExample.StaticAndDynamicFilter;

import java.util.ArrayList;
import java.util.List;

public class ServiceSD {
    private static List<UserDetails> userDetailsList = new ArrayList<>();


    //setting up values of Employee bean
    static {
        userDetailsList.add(new UserDetails("Muskan", 22, "3rewr"));
        userDetailsList.add(new UserDetails("Geetanjali", 32, "3sjd"));


    }


}
