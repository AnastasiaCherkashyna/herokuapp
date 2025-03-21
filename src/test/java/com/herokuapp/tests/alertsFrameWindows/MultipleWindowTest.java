package com.herokuapp.tests.alertsFrameWindows;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.alertsFrameWindows.MultipleWindowPage;
import com.herokuapp.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MultipleWindowTest extends TestBase {

    @BeforeEach
    public void precondition(){
        new HomePage(driver).getMultipleWindow();
    }

    @Test
    public void switchToNewTabTest(){
        new MultipleWindowPage(driver).switchToNewWindow(1).verifyNewWindowTitle("New Window");
    }
}
