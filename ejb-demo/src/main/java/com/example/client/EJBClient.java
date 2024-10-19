package com.example.client;

import com.example.ejb.HelloBeanRemote;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;

public class EJBClient {

    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        InitialContext ctx = new InitialContext(props);

        // Lookup the EJB
        HelloBeanRemote helloBean = (HelloBeanRemote) ctx.lookup("ejb:/ejb-demo/HelloBean!com.example.ejb.HelloBeanRemote");

        // Call the EJB method
        String result = helloBean.sayHello("World");
        System.out.println(result);
    }
}