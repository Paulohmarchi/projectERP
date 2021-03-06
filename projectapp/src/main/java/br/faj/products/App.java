package br.faj.products;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    private static final Logger logger = Logger.getLogger(App.class);
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
