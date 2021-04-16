import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {
    public static WebDriver SelectWebDriver(String browserName) {
        WebDriver webDriver = null;
        String path = System.getProperty("user.dir");
        if ("Chrome".equals(browserName)) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            webDriver = new ChromeDriver();
        } else if ("IE".equals(browserName)) {
            System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");
            webDriver = new InternetExplorerDriver();
        } else {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
            webDriver = new FirefoxDriver();
        }
        return webDriver;
    }
}
