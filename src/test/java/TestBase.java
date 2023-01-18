import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    WebDriver dr;

    public static Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void init(){
//        System.setProperty("webdriver.chrome.driver", "/Users/ilya/telran/Tools/chromedriver108");
        dr = new ChromeDriver();
        dr.get("http://phonebook.telran-edu.de:8080/user/login");
        dr.manage().window().maximize();
        dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod(enabled = true)
    public void tearDown(){
        dr.quit();
    }

    public static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
