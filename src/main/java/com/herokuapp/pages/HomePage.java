package com.herokuapp.pages;

import com.herokuapp.config.BasePage;
import com.herokuapp.pages.alertsFrameWindows.AlertPage;
import com.herokuapp.pages.alertsFrameWindows.IframePage;
import com.herokuapp.pages.alertsFrameWindows.MultipleWindowPage;
import com.herokuapp.pages.brokenImages.BrokenImagesPage;
import com.herokuapp.pages.contextMenu.ContextMenuPage;
import com.herokuapp.pages.dropDown.DropDownPage;
import com.herokuapp.pages.interactions.DragAndDropPage;
import com.herokuapp.pages.statusCode.StatusCodePage;
import com.herokuapp.pages.uploadFile.UploadFilePage;
import com.herokuapp.pages.widgits.SliderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.module.Configuration;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href='/javascript_alerts']")
    WebElement javaScriptAlerts;

    public AlertPage getAlertWindow() {
        javaScriptAlerts.click();
        return new AlertPage(driver);
    }


    @FindBy(css = "a[href='/frames']")
    WebElement frames;
    public IframePage getFramesWindow() {
        frames.click();
        return new IframePage(driver);
    }

    @FindBy(css = "a[href='/windows']")
    WebElement windows;

    public MultipleWindowPage getMultipleWindow() {
        click(windows);
        return new MultipleWindowPage(driver);
    }

    @FindBy(css = "a[href='/dropdown']")
    WebElement dropDown;
    public DropDownPage getDropDown() {
        click(dropDown);
        return new DropDownPage(driver);
    }

    @FindBy(css = "a[href='/horizontal_slider']")
    WebElement slider;
    public SliderPage getSlider() {
        click(slider);
        return new SliderPage(driver);

    }

    @FindBy(css = "a[href='/drag_and_drop']")
    WebElement dragAndDrop;
    public DragAndDropPage getDragAndDrop() {
    click(dragAndDrop);
    return new DragAndDropPage(driver);
    }

    @FindBy(css = "a[href='/context_menu']")
    WebElement menu;
    public ContextMenuPage getContextMenu() {
        click(menu);
        return new ContextMenuPage(driver);
    }

    @FindBy(css = "a[href='/broken_images']")
    WebElement brokenImages;
    public BrokenImagesPage getBrokenImagesPage() {
        click(brokenImages);
        return new BrokenImagesPage(driver);
    }

    @FindBy(css = "a[href='/status_codes']")
    WebElement status;
    public StatusCodePage getStatusCode() {
        click(status);
        return new StatusCodePage(driver);
    }

    @FindBy(css = "a[href='/upload']")
    WebElement upload;
    public UploadFilePage getUpload() {
        click(upload);
        return  new UploadFilePage(driver);

    }
}
