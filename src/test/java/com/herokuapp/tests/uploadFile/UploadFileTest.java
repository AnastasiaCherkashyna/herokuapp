package com.herokuapp.tests.uploadFile;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.uploadFile.UploadFilePage;
import com.herokuapp.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UploadFileTest extends TestBase {

    @BeforeEach
    public void precondition(){
        new HomePage(driver).getUpload();
    }

    @Test
    public void uploadFileTest(){
        new UploadFilePage(driver)
                .uploadFile("/Users/anastasiacherkashyna/Tools/Eibsee-20.jpg")
                .verifyUpload("File Uploaded!");
    }
}
