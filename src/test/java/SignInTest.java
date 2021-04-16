import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;


public class SignInTest {
    private WebDriver driver;
    private  Properties prop;

    @Before
    public void Before(){
    }

    @Test
    public void LogIn() throws Exception {
        driver = WebDriverFactory.SelectWebDriver("Chrome");
        driver.manage().window().maximize();
        driver.get("https://now.dstv.com/");

        driver.findElement(By.xpath("//*[@id=\"root\"]/header/div/div/div[2]/button")).click();

        driver.findElement(By.xpath("//*[@id=\"EmailOrMobileNumber\"]")).sendKeys("nondstvprod@mailinator.com");

        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("123456");

        driver.findElement(By.xpath("//*[@id=\"btnSubmit\"]")).click();

        driver.findElement(By.xpath("/html/body/div[1]/main/div/section/div[2]/div/div/a")).click();

        Thread.sleep(2000);
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/section/ul/li[1]/div/div"));
        action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/main/section/ul/li[1]/div/div/img"))).click().build().perform();

        List<WebElement> homeElements = driver.findElements(By.xpath("//*[@id=\"root\"]/header/div/div/div[2]/nav/ul/li"));
        Assert.assertTrue("Not In Home Page",homeElements.size()>=8);
    }

    @After
    public void Flush(){
       driver.close();
    }
}


