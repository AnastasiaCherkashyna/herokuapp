package com.herokuapp.config;

import com.herokuapp.pages.alertsFrameWindows.AlertPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

public class BasePage {

    public WebDriver driver;

    public static JavascriptExecutor js;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        js = (JavascriptExecutor) driver;
    }

    public void click(WebElement element){
        element.click();
    }

    protected boolean containsText(WebElement element, String text) {

        return element.getText().contains(text);
    }
    public boolean isAlertPresent() {
        AlertPage alert = new AlertPage(driver);
        if (alert==null){
            return false;
        }
        driver.switchTo().alert().accept();
        return true;

    }
    public WebDriverWait wait(int time) {

        return new WebDriverWait(driver, Duration.ofSeconds(time));
    }

    public boolean shouldHaveText(WebElement element, String text, int time) {
        return wait(time)
                .until(ExpectedConditions.textToBePresentInElement(element,text));
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void verifyLinks(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            //созд соединеие с сервером url connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();
            //get response code
            if(connection.getResponseCode() >= 400){
                System.out.println(linkUrl + " - " + connection.getResponseMessage() + "is broken.");

            } else{
                System.out.println(linkUrl + connection.getResponseMessage() + " SUCCESS");
            }
        } catch (IOException e) {
            System.out.println(linkUrl + e.getMessage() + "error occurred");
        }
    }
}
