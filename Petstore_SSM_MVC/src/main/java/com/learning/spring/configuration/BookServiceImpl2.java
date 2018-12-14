package com.learning.spring.configuration;

import com.learning.spring.BookService;

public class BookServiceImpl2 implements BookService {
    @Override
    public void sayHello() {
        System.out.println("您好，中国。");
    }
}
