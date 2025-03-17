package com.herokuapp.pages.alertsFrameWindows;

import com.herokuapp.config.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertPage extends BasePage {

    public AlertPage alert;

    public AlertPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Click for JS Alert']")
    WebElement jsAlert;

    public AlertPage verifyAlertIsPresent() {
        jsAlert.click();
        Assertions.assertTrue(isAlertPresent());
        return this;
    }


    //@FindBy(xpath = "//ul//li[2]")
    @FindBy(xpath = "//button[text()='Click for JS Confirm']")
    WebElement confirmButton;

    public AlertPage selectResult(String result) {
        confirmButton.click();
        if (result != null && result.equals("Ok")) {
            driver.switchTo().alert().accept();
        } else if (result != null && result.equals("Cancel")) {
            driver.switchTo().alert().dismiss();
        }
        return this;
    }

    @FindBy(id = "result")
    WebElement confirmResult;

    public AlertPage verifyResult(String result) {
        Assertions.assertTrue(containsText(confirmResult, result));

        return this;
    }

    @FindBy(xpath = "//ul/li[3]/button")
    WebElement promptButton1;
    public AlertPage clickPromptButton() {
        click(promptButton1);
        return this;
    }
    public AlertPage sendMessage(String message) {
        Alert alert1 = new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
        if (alert1 != null && message != null) {
            driver.switchTo().alert().sendKeys(message);
            alert1.accept();
        }
        return this;
    }

    @FindBy(id = "result")
    WebElement result;

    public AlertPage verifyMessage(String message) {
        Assertions.assertTrue(shouldHaveText(result,message,2));
        return this;
    }



}

