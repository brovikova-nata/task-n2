package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Job_test {
    WebDriver driver;

    @FindBy(xpath = "//div[@id='mainmenu']/ul/li[6]/a")
    WebElement jobPage;

    @FindBy(name = "text")
    WebElement textfield;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submit;

    public Job_test(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setparameters() {
        textfield.clear();
        textfield.sendKeys("Специалист по тестированию");
        submit.click();
    }

    public void check() throws Exception {
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='search-result-item__head']/a"));
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i).getText().toLowerCase().contains("специалист")) && (list.get(i).getText().toLowerCase().contains("тестировани"))) {
                //System.out.println(list.get(i).getText());
                return;
            }
        }
        throw new Exception("There are no offers for you");
    }
}


