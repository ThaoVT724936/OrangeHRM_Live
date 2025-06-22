package pageObjects.pim.employee;

import org.openqa.selenium.WebDriver;

public class MembershipsPO extends SidebarEmployeePO{
    private WebDriver driver;
    public MembershipsPO(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
}
