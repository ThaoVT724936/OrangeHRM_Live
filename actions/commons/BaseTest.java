package commons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import pim.PIM_01_Employee;

import java.time.Duration;

public abstract class BaseTest {
    private WebDriver driver;
      public WebDriver getBrowserName(String browserName) {
        try {
            BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
            switch (browserList) {
                case FIREFOX:
                    driver = new FirefoxDriver();
                    break;
                case CHROME:
                    driver = new ChromeDriver();
                    break;
                case EDGE:
                    driver = new EdgeDriver();
                    break;
                case SAFARI:
                    driver = new SafariDriver();
                    break;
                default:
                    throw new RuntimeException("Browser is not supported!!!");
            }
        } catch (Exception ex) {
            throw new RuntimeException("Browser is not supported!!!");
        }
        driver.get(GlobalConstants.PAGE_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.SHORT_TIME));
        return driver;
    }

    protected WebDriver getDriver() {
        return driver;
    }

}
