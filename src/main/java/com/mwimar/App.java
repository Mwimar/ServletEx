package com.mwimar;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class App
{
    public static void main( String[] args ) throws LifecycleException {
        System.out.println( "Hey YAll!" );
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        Context context = tomcat.addContext("",null);
        Tomcat.addServlet(context,"HeyServlet", new HeyServlet());
        context.addServletMappingDecoded("/hey","HeyServlet");

        tomcat.start();
        tomcat.getServer().await();

    }
}
