package pageObjects.pim.employee;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.PIM.employee.AddNewEmployeeUI;

public class AddNewEmployeePO extends BasePage {
/*
    private WebDriver driver;
*/
    public AddNewEmployeePO(WebDriver driver){
        super(driver);
/*
        this.driver = driver;
*/
    }

    @Step("Get EmployeeID value")
    public String getEmployeeID(){
        return getAttributeValue(driver, AddNewEmployeeUI.EMPLOYEE_ID_TEXTBOX,"value");
    }

    @Step("Enter firstname: {0}")
    public void enterFirstName(String firstName) {
        waitForElementVisible(driver,AddNewEmployeeUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver,AddNewEmployeeUI.FIRST_NAME_TEXTBOX, firstName);
    }

    @Step("Enter middlename: {0}")
    public void enterMiddleName(String middleName) {
        waitForElementVisible(driver,AddNewEmployeeUI.MIDDLE_NAME_TEXTBOX);
        sendkeyToElement(driver,AddNewEmployeeUI.MIDDLE_NAME_TEXTBOX, middleName);
    }

    @Step("Enter lastname: {0}")
    public void enterLastName(String lastName) {
        waitForElementVisible(driver,AddNewEmployeeUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver,AddNewEmployeeUI.LAST_NAME_TEXTBOX, lastName);
    }

    @Step("Upload avatar: {0}")
    public void uploadAvatar(String avatarInAddNew) {
        waitForElementVisible(driver,AddNewEmployeeUI.UPLOAD_AVATAR);
        sendkeyToElement(driver,AddNewEmployeeUI.UPLOAD_AVATAR, avatarInAddNew);
    }

    @Step("Click to Save employee button")
    public PersonalDetailsPO clickToSaveButton() {
        waitForElementClickable(driver, AddNewEmployeeUI.SAVE_BUTTON);
        clickToElement(driver,AddNewEmployeeUI.SAVE_BUTTON);
        waitForSuccessMessageDisplayed(driver);
        return PageGenerator.getPersonalDetailsPOInEmployee(driver);
    }
}
