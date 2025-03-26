package com.herokuapp.tests.brokenImagesTest;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.brokenImages.BrokenImagesPage;
import com.herokuapp.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BrokenImagesTest extends TestBase {

    @BeforeEach
    public void precondition(){
        new HomePage(driver).getBrokenImagesPage();
    }

    @Test
    public void getBrokenImagesTest(){
        new BrokenImagesPage(driver).verifyBrokenImages();
    }
}
