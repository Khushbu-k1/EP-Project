
package com.example.ejb;

import javax.ejb.Stateless;

@Stateless
public class HelloBean implements HelloBeanRemote {
    public String sayHello(String name) {
        return "Hello, " + name + " from EJB!";
    }
}