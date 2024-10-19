package com.example.ejb;

import javax.ejb.Remote;

@Remote
public interface HelloBeanRemote {
    String sayHello(String name);
}

