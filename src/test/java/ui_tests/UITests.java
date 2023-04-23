package ui_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import lombok.extern.log4j.Log4j2;

import io.qameta.allure.Description;

@Log4j2
public class UITests {

    @Test(description = "Test stub")
    @Description("Fake test")
    public void test(){
        log.info("Logger test");
        Assert.assertEquals(2+2,4);
    }
}
