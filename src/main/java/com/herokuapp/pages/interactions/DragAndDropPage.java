package com.herokuapp.pages.interactions;

import com.herokuapp.config.BasePage;
import com.herokuapp.pages.dropDown.DropDownPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage {
    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "column-a")
    WebElement dragMe;

    @FindBy(id = "column-b")
    WebElement dropHere;

    public DragAndDropPage actionDragMe() {
        pause(1000);

        new Actions(driver).dragAndDrop(dragMe,dropHere).perform();
        return this;
    }


    public DragAndDropPage verifyDropped(String text) {
        Assertions.assertTrue(containsText(dropHere,text));
        return this;
    }
}
