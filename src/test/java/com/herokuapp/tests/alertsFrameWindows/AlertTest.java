package com.herokuapp.tests.alertsFrameWindows;

import com.herokuapp.pages.alertsFrameWindows.AlertPage;
import com.herokuapp.pages.HomePage;
import com.herokuapp.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AlertTest extends TestBase {

    public AlertPage alert;


    @BeforeEach
    public void precondition(){
        alert =  new AlertPage(driver);
        new HomePage(driver).getAlertWindow();
    }

    @Test
    @DisplayName("Verify to - alert is appeared")
    public void clickAlertButtonTest(){
        alert.verifyAlertIsPresent();
    }

    @Test
    @DisplayName("Verify to - 'Cancel' is displayed")
    public void canselAlertTest(){
        alert.selectResult("Cancel").verifyResult("Cancel");
    }

    @Test
    @DisplayName("Verify to -  alert's prompt field is filled")
    public void fillPromptInAlertTest(){
        alert = new AlertPage(driver);
        alert.clickPromptButton()
               .sendMessage("Hello")
                .verifyMessage("Hello");
    }

}
