package org.spring.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import exception.Errorexception;



/**
 * Hello world!
 *
 */

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "org.spring.dao", "org.spring.service", "org.spring.controller"})
@EnableTransactionManagement
@EntityScan(basePackages = "org.spring.model")
public class App 
{
    public static void main( String[] args ) throws Errorexception{
    	SpringApplication.run(App.class, args);
    	    	   
    }
}
