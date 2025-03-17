package com.herokuapp.pages.alertsFrameWindows;

import com.herokuapp.config.BasePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.function.BooleanSupplier;

public class IframePage extends BasePage {
    public IframePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href='/iframe']")
    WebElement frames;
    public IframePage getIframeWindow() {
        frames.click();
        return new IframePage(driver);
    }
    @FindBy(css = "h3")
    WebElement pageTitle;

    public boolean isOnFramesPage() {
        return pageTitle.isDisplayed();
    }


    // Почему этот метод не виден в ТЕстах NEsted, когда он в NestedFramesPage
    @FindBy(css = "a[href='/nested_frames']")
    WebElement nestedFrame;

    public NestedFramesPage getNestedFrameWindow() {
        nestedFrame.click();
        return new NestedFramesPage(driver);
    }


    @FindBy(id = "mce_0_ifr")
    WebElement frameId;
    public IframePage switchToIframeById() {
        driver.switchTo().frame(frameId);
        return this;
    }



    @FindBy(xpath = "//iframe[text()='Your content goes here.']")
    WebElement title;
    public IframePage verifyFrameByText() {
        driver.switchTo().frame(title);
        Assertions.assertEquals("Your content goes here.", title.getText());
        return this;
    }

    public IframePage returnToMainPage() {
        driver.switchTo().defaultContent();
        return this;
    }





}
