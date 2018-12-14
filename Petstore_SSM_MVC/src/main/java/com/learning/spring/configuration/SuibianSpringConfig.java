package com.learning.spring.configuration;

import com.learning.spring.BookDAO;
import com.learning.spring.BookService;
import com.learning.spring.BookServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SuibianSpringConfig {

    @Bean
    public BookService bs(){
        System.out.println(bookDAO());
        if(Math.random() > 0.5){
            return new BookServiceImpl();
        }else{
            return new BookServiceImpl2();
        }
    }

    @Bean
    public BookDAO bookDAO(){
        return new BookDAO();
    }
}
