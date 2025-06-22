package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.pim.employee.EmployeeListPO;

public class PimPO extends MainMenuPO {
    private WebDriver driver;
    public PimPO(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

}
