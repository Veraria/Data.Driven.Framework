package rs.helloworld.rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    public static void main(String[] args) throws IOException {
        Properties config = new Properties();
        Properties OR = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
    /** made the absolute path shorter + more consistent in case of changing the file source
     *  by using System.getProperty("user.dir")
     */
        config.load(fis);
        // this is just to show what we get in the console after printing
        System.out.println(config.getProperty("browser"));

        fis = new FileInputStream(System.getProperty("user.dir")+"src\\test\\resources\\properties\\OR.properties");
        OR.load(fis);

        /** if I want to reach locator from OR.properties
         * driver.findElement(By.cssSelector(OR.getProperty("  "))).click();
          */
    }
}
