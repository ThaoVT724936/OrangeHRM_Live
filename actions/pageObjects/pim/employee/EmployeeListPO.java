package pageObjects.pim.employee;

import commons.BasePage;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.PIM.employee.EmployeeListUI;

public class EmployeeListPO extends BasePage {
    private WebDriver driver;
    public EmployeeListPO(WebDriver driver){
        this.driver = driver;
    }

    public AddNewEmployeePO clickToAddEmployeeTab() {
        waitForElementClickable(driver, EmployeeListUI.ADD_EMPLOYEE_TAB);
        clickToElement(driver,EmployeeListUI.ADD_EMPLOYEE_TAB);
        return PageGenerator.getAddNewEmployeePO(driver);
    }
}
