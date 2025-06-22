package pageObjects.pim.employee;

import org.openqa.selenium.WebDriver;

public class ContactDetailsPO extends SidebarEmployeePO{
    private WebDriver driver;
    public ContactDetailsPO(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
}
