package com.herokuapp.pages.alertsFrameWindows;

import com.herokuapp.config.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MultipleWindowPage extends BasePage {
    public MultipleWindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href='/windows/new']")
    WebElement newWindow;

    public MultipleWindowPage switchToNewWindow(int index) {
        click(newWindow);

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));

        return this;
    }

    @FindBy(css = "h3")
    WebElement tabTitle;
    public MultipleWindowPage verifyNewWindowTitle(String title) {
        Assertions.assertTrue(shouldHaveText(tabTitle,title, 5));
        return this;
    }
}
