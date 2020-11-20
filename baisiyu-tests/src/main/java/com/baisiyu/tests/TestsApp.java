package com.baisiyu.tests;

import com.baisiyu.common.constants.Contants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestsApp {
    static Logger LOGGER = LoggerFactory.getLogger(TestsApp.class);

    public static void main(String[] args) {
        LOGGER.info("start test project:{}", Contants.APP_NAME);
        SpringApplication.run(TestsApp.class, args);
    }
}
