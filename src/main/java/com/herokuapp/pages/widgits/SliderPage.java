package com.herokuapp.pages.widgits;

import com.herokuapp.config.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.security.Signature;

public class SliderPage extends BasePage {
    public SliderPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "input[type='range']")
    WebElement slider;
    public SliderPage moveSliderToHorizontal() {
        pause(1000);

        new Actions(driver).dragAndDropBy(slider,100,0).perform();
        return this;
    }

    public SliderPage verifyByValue(String expectedValue) {
        String actualValue = slider.getAttribute("value");
        Assertions.assertEquals(expectedValue, actualValue);
        return this;
    }
}
