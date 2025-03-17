package com.herokuapp.pages.alertsFrameWindows;

import com.herokuapp.config.BasePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NestedFramesPage extends BasePage {
    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }



    @FindBy(tagName = "frame")
    List<WebElement> iframes;
    public NestedFramesPage countParentFramesTest(){
        int expectedFrameCount = 2;
        Assertions.assertEquals(expectedFrameCount,iframes.size());
        return this;
    }


    public NestedFramesPage returnToMainPage() {
        driver.switchTo().defaultContent();
        return this;
    }

    @FindBy(tagName = "h1")
    WebElement title;
    public NestedFramesPage verifyMainPageByTitle(String text) {
        Assertions.assertTrue(containsText(title,text));
        return this;
    }

    @FindBy(xpath = "//ul/li[1]/a")
    WebElement nestedFrames;

    public NestedFramesPage selectNestedFrames() {
        click(nestedFrames);
        return this;
    }

    @FindBy(id = "content")
    WebElement content;

    public NestedFramesPage switchToMiddle() {
        driver.switchTo().frame(0);
        driver.switchTo().frame(1);
        return this;
    }

    public NestedFramesPage verifyFrame(String title) {
        Assertions.assertTrue(shouldHaveText(content,title,5));
        return this;
    }



}
