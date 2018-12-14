package com.learning.components;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("learning/spring/my-spring.xml");
        Goal goal = (Goal) applicationContext.getBean("goal");
        System.out.println(goal);
    }

}
