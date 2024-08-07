package com.library;

import com.library.service.LibraryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        LibraryService libraryService = context.getBean(LibraryService.class);
        libraryService.someMethod();
        libraryService.anotherMethod();
    }
}
