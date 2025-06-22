package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.pim.employee.*;
import pageUIs.LoginUI;

public class LoginPO extends BasePage {
    private WebDriver driver;
    public LoginPO (WebDriver driver){
        this.driver = driver;
    }
    public void enterUserName(String userName){
        waitForElementVisible(driver, LoginUI.USER_NAME_TEXTBOX);
        sendkeyToElement(driver,LoginUI.USER_NAME_TEXTBOX, userName);
    }
    public void enterPassword(String password){
        waitForElementVisible(driver, LoginUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver,LoginUI.PASSWORD_TEXTBOX, password);
    }
    public DashboardPO clickToLoginButton(){
        waitForElementClickable(driver, LoginUI.LOGIN_BUTTON);
        clickToElement(driver, LoginUI.LOGIN_BUTTON);
        return PageGenerator.getDashboardPO(driver);
    }
}
