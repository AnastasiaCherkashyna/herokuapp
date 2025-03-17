package com.herokuapp.tests.alertsFrameWindows;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.alertsFrameWindows.IframePage;
import com.herokuapp.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IframeTest extends TestBase {

    public IframePage iframe;

    @BeforeEach
    public void precondition(){
        new HomePage(driver).getFramesWindow();
        new IframePage(driver).getIframeWindow();

    }

    @Test
    @DisplayName("Verify to - h3 'Frame' is displayed")
    public void frameTest(){
        new IframePage(driver).isOnFramesPage();

    }

    @Test
    @DisplayName("Find iframe by locator")
    public void findIframeByLocatorTest(){
        new IframePage(driver)
                .switchToIframeById()
              //.verifyFrameByText()
                //.returnToMainPage()
                //.verifyFrameByText()
        ;
    }

}
