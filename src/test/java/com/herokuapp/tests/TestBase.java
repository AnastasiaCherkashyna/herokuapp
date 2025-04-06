package com.herokuapp.tests;

import com.herokuapp.config.ApplicationManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser","chrome"));
    public WebDriver driver;
    public static Logger logger = LoggerFactory.getLogger(TestBase.class);


    @BeforeEach
    public void init(TestInfo testInfo){
        driver = app.startTest();
        logger.info("Start test -> " + testInfo.getTestMethod().toString());
    }

    @AfterEach
    public void stop(){
        app.stopTest();
        logger.info("Stop test");
        logger.info("****************************************");
    }

}

