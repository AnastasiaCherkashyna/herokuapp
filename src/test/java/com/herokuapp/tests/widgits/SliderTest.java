package com.herokuapp.tests.widgits;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.widgits.SliderPage;
import com.herokuapp.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SliderTest extends TestBase {
    @BeforeEach
    public void precondition(){
        new HomePage(driver).getSlider();
    }

    @Test
    public void moveSliderToHorizontalDirection(){
        new SliderPage(driver).moveSliderToHorizontal()
                .verifyByValue("5");
    }
}
