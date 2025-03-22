package com.herokuapp.tests.interactions;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.interactions.DragAndDropPage;
import com.herokuapp.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DragAndDropTest extends TestBase {
    @BeforeEach
    public void precondition() {
        new HomePage(driver).getDragAndDrop();
    }

    @Test
    public void actionDragMeTest() {
        new DragAndDropPage(driver).actionDragMe()
                .verifyDropped("A");
    }
}
