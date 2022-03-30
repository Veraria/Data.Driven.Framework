package rs.helloworld.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import rs.helloworld.base.TestBase;

public class LoginTest extends TestBase {
    @Test
    public void customerLogin () throws InterruptedException {

        log.info("Inside Login Test");
        driver.findElement(By.xpath(OR.getProperty("prijaviseButton"))).click();

        //Thread.sleep(6000);
        log.info("Login successfully executed");

    }
}
