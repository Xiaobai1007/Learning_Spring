package com.learning.spring.configuration;

import com.learning.spring.BookDAO;
import com.learning.spring.BookService;
import com.learning.spring.BookServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = "learning/spring/my-spring.xml")
public class SuibianSpringConfig2 {

    @Bean
    public BookService bs1() {
        System.out.println(bookDAO());
        if(Math.random() > 0.5){
            return new BookServiceImpl();
        }else{
            System.out.println("重新开始");
        }
        return null;
    }

    @Bean
    public BookDAO bookDAO () {
        return new BookDAO();
    }

}
