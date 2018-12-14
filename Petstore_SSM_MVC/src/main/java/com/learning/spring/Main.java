package com.learning.spring;

import com.learning.spring.configuration.SuibianSpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        chuantongXML();
    }

    public static void chuantongXML(){
        ApplicationContext conn = new ClassPathXmlApplicationContext("learning/spring/my-spring.xml");
        BookService bookService = (BookService) conn.getBean("bs");
        bookService.sayHello();
    }

    public static void zhuliuAnnotation (){
        AnnotationConfigApplicationContext anno = new AnnotationConfigApplicationContext(SuibianSpringConfig.class);
        BookService bookService = (BookService) anno.getBean("bs");
        bookService.sayHello();
    }

}
