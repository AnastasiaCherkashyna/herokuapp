package com.herokuapp.pages.dropDown;

import com.herokuapp.config.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage extends BasePage {
    public DropDownPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "dropdown")
    WebElement dropDown;
    public DropDownPage selectOption() {
        Select select = new Select(dropDown);
        select.selectByValue("1");
        return this;

    }

    public DropDownPage verifySelectedOption() {
        String result = new Select(dropDown).getFirstSelectedOption().getText();
        Assertions.assertTrue(shouldHaveText(dropDown,result,5));
        return this;
    }
}
