package PageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Run_test {
    WebDriver driver;
    Job_test Page;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.tut.by/");
    }

    @AfterTest
    public void quit() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test()
    public void main_test() throws Exception {
        Page = new Job_test(driver);
        Page.jobPage.click();
        Page.setparameters();
        Page.check();
    }
}