package com.herokuapp.tests.contextMenu;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.contextMenu.ContextMenuPage;
import com.herokuapp.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ContextMenuTest extends TestBase {
    @BeforeEach
    public void precondition(){
        new HomePage(driver).getContextMenu();
    }

    @Test
    @Tag("smoke")
    public void rightClickTest(){
        new ContextMenuPage(driver).rightClick().verifyAlert();
    }
}
