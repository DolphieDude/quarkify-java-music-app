package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

    public String greeting(String name) {
        String formattedName = name;

        if (formattedName.length() > 1) {
            formattedName = ("" + name.charAt(0)).toUpperCase() + name.substring(1);
        }

        return "Hello, " + formattedName;
    }

}
