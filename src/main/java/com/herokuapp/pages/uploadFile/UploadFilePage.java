package com.herokuapp.pages.uploadFile;

import com.herokuapp.config.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UploadFilePage extends BasePage {
    public UploadFilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "file-upload")
    WebElement fileUpload;
    public UploadFilePage uploadFile(String path) {
        fileUpload.sendKeys(path);
        return this;
    }

    @FindBy(id = "file-submit")
    WebElement fileSubmit;

    @FindBy(id = "content")
    WebElement content;
    public UploadFilePage verifyUpload(String text) {
        click(fileSubmit);
        Assertions.assertTrue(shouldHaveText(content,text,5));
        return this;
    }
}
