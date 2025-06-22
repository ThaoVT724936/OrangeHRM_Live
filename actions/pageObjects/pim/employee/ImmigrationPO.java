package pageObjects.pim.employee;

import org.openqa.selenium.WebDriver;

public class ImmigrationPO extends SidebarEmployeePO{
    private WebDriver driver;
    public ImmigrationPO(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
}
