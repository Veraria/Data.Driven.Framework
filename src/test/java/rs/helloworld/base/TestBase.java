package rs.helloworld.base;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class TestBase {

    public static WebDriver driver;
    public static Properties config = new Properties();
    public static Properties OR = new Properties();
    public static FileInputStream fis;
    public static Logger log = Logger.getLogger("devpinoylogger");



    @BeforeSuite
    public void setUp() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            config.load(fis);
            log.info("Config file loaded.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            OR.load(fis);
            log.info("OR file loaded");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (config.getProperty("browser").equals("edge")){
            System.setProperty("webdriver.edge.driver","edge.exe"); //proveriti ovo
            driver = new EdgeDriver();
            // or driver = new ChromiumDriver();
        }else if (config.getProperty("browser").equals("chrome")){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\src\\test\\resources\\executables\\chromedriver.exe");
            driver = new ChromeDriver();
            log.info("Chrome launched");
        }
        driver.get(config.getProperty("testsiteURL"));
        log.info("Navigated to "+config.getProperty("testsiteURL"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterSuite
    public void tearDown(){
        //moze li i bez ovoga uslova?
        if (driver !=null){
        driver.quit();
        log.info("Test execution completed");
    }
}}
