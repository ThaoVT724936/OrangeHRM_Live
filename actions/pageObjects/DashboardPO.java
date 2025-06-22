package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.pim.employee.*;

public class DashboardPO extends MainMenuPO {
    private WebDriver driver;
    public DashboardPO(WebDriver driver){
        super(driver);
        this.driver = driver;
    }


}
