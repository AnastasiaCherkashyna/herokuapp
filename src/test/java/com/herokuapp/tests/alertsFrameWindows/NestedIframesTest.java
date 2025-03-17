package com.herokuapp.tests.alertsFrameWindows;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.alertsFrameWindows.NestedFramesPage;
import com.herokuapp.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NestedIframesTest extends TestBase {

    public NestedFramesPage nest;
    @BeforeEach
    public void precondition(){
        new HomePage(driver).getFramesWindow().getNestedFrameWindow();
        }


    @Test
    @DisplayName("Verify to - list of parent frames")
    public void returnSizeOfParentFramesTest(){
        new NestedFramesPage(driver).countParentFramesTest();
    }

    @Test
    public void selectMiddleTest() {
        new NestedFramesPage(driver).switchToMiddle()
                .verifyFrame("MIDDLE");
    }
}

