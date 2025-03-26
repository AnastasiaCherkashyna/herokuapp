package com.herokuapp.pages.brokenImages;

import com.herokuapp.config.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BrokenImagesPage extends BasePage {
    public BrokenImagesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "img")
    List<WebElement> images;
    public BrokenImagesPage verifyBrokenImages() {
            System.out.println(images.size());

           for (int i = 0; i < images.size(); i++) {
                WebElement element = images.get(i);
                String imageUrl = element.getAttribute("src");
                verifyLinks(imageUrl);

                try {
                    boolean imageDisplayed = (Boolean)js.executeScript
                            ("return (typeof arguments[0].naturalWidth!=undefined && arguments[0].naturalWidth>0);",element);
                    if(imageDisplayed){
                        System.out.println("OK");
                        System.out.println("******************");
                    }else{
                        System.out.println("BROKEN");
                    }
                } catch (Exception e) {
                    System.out.println("ERROR OCCURRED");
                }
            }
        return this;
    }
}
