package com.herokuapp.tests.statusCode;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.statusCode.StatusCodePage;
import com.herokuapp.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StatusCodeTest extends TestBase {
    @BeforeEach
    public void precondition(){
        new HomePage(driver).getStatusCode();
    }

@Test
    public void verifyBrokenLinksTest(){
        new StatusCodePage(driver).verifyStatusLinks();
}

}
