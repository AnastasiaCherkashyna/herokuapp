package com.herokuapp.pages.statusCode;

import com.herokuapp.config.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StatusCodePage extends BasePage {
    public StatusCodePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a")
    List<WebElement> allLinks;
    public StatusCodePage verifyStatusLinks() {
            for (int i = 0; i < allLinks.size(); i++) {
                WebElement element = allLinks.get(i);
                String url = element.getAttribute("href");
                verifyLinks(url);
            }
            return this;
        }
    }

