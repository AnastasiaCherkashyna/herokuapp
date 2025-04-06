package com.herokuapp.tests.dropDown;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.dropDown.DropDownPage;
import com.herokuapp.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class DropDownTest extends TestBase {

    @BeforeEach
    public void precondition(){
        new HomePage(driver).getDropDown();
    }

    @Test
    @Tag("smoke")
    public void selectOptionInDropDown(){
        new DropDownPage(driver).selectOption().verifySelectedOption();
    }
}
