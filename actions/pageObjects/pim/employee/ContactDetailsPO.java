package pageObjects.pim.employee;

import employeeData.ContactDetailsJson;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pageUIs.PIM.employee.ContacDetailsUI;

public class ContactDetailsPO extends SidebarEmployeePO{
/*
    private WebDriver driver;
*/
    public ContactDetailsPO(WebDriver driver){
        super(driver);
/*
        this.driver = driver;
*/
    }

    //get contact details
    public String getStreet1() {
        waitForElementVisible(driver,ContacDetailsUI.STREET1);
        return getAttributeValue(driver,ContacDetailsUI.STREET1,"value");
    }

    public String getStreet2() {
        waitForElementVisible(driver,ContacDetailsUI.STREET2);
        return getAttributeValue(driver,ContacDetailsUI.STREET2,"value");
    }

    public String getCity() {
        waitForElementVisible(driver,ContacDetailsUI.CITY);
        return getAttributeValue(driver,ContacDetailsUI.CITY,"value");
    }

    public String getStateProvince() {
        waitForElementVisible(driver,ContacDetailsUI.STATE_PROVINCE);
        return getAttributeValue(driver,ContacDetailsUI.STATE_PROVINCE,"value");
    }

    public String getZipPostalCode() {
        waitForElementVisible(driver,ContacDetailsUI.ZIP_POSTAL_CODE);
        return getAttributeValue(driver,ContacDetailsUI.ZIP_POSTAL_CODE,"value");
    }

    public String getCountry() {
        waitForElementVisible(driver,ContacDetailsUI.COUNTRY_BUTTON);
        return getTextElement(driver,ContacDetailsUI.COUNTRY_BUTTON);
    }

    public String getHome() {
        waitForElementVisible(driver,ContacDetailsUI.HOME);
        return getAttributeValue(driver,ContacDetailsUI.HOME,"value");
    }

    public String getMobile() {
        waitForElementVisible(driver,ContacDetailsUI.MOBILE);
        return getAttributeValue(driver,ContacDetailsUI.MOBILE,"value");
    }

    public String getWork() {
        waitForElementVisible(driver,ContacDetailsUI.WORK);
        return getAttributeValue(driver,ContacDetailsUI.WORK,"value");
    }

    public String getWorkEmail() {
        waitForElementVisible(driver,ContacDetailsUI.WORK_EMAIL);
        return getAttributeValue(driver,ContacDetailsUI.WORK_EMAIL,"value");
    }

    public String getOtherEmail() {
        waitForElementVisible(driver,ContacDetailsUI.OTHER_EMAIL);
        return getAttributeValue(driver,ContacDetailsUI.OTHER_EMAIL,"value");
    }

    //enter contact details
    public void enterStreet1(String street1) {
        waitForElementVisible(driver, ContacDetailsUI.STREET1);
        clearValueInTextbox(driver, ContacDetailsUI.STREET1);
        sendkeyToElement(driver,ContacDetailsUI.STREET1,street1);
    }

    public void enterStreet2(String street2) {
        waitForElementVisible(driver, ContacDetailsUI.STREET2);
        clearValueInTextbox(driver, ContacDetailsUI.STREET2);
        sendkeyToElement(driver,ContacDetailsUI.STREET2,street2);
    }

    public void enterCity(String city) {
        waitForElementVisible(driver, ContacDetailsUI.CITY);
        clearValueInTextbox(driver, ContacDetailsUI.CITY);
        sendkeyToElement(driver,ContacDetailsUI.CITY,city);
    }

    public void enterStateProvince(String stateProvince) {
        waitForElementVisible(driver, ContacDetailsUI.STATE_PROVINCE);
        clearValueInTextbox(driver, ContacDetailsUI.STATE_PROVINCE);
        sendkeyToElement(driver,ContacDetailsUI.STATE_PROVINCE,stateProvince);
    }

    public void enterZipPostalCode(String ZipPostalCode) {
        waitForElementVisible(driver, ContacDetailsUI.ZIP_POSTAL_CODE);
        clearValueInTextbox(driver, ContacDetailsUI.ZIP_POSTAL_CODE);
        sendkeyToElement(driver,ContacDetailsUI.ZIP_POSTAL_CODE,ZipPostalCode);
    }

    public void selectCountry(String selectItem) {
        waitForElementClickable(driver,ContacDetailsUI.COUNTRY_BUTTON);
        clickToElement(driver,ContacDetailsUI.COUNTRY_BUTTON);
        selectItemInCustomDropdown(driver,ContacDetailsUI.COUNTRY_LIST_OPTION,selectItem);
    }

    public void enterHome(String home) {
        waitForElementVisible(driver, ContacDetailsUI.HOME);
        clearValueInTextbox(driver, ContacDetailsUI.HOME);
        sendkeyToElement(driver,ContacDetailsUI.HOME,home);
    }

    public void enterMobile(String mobile) {
        waitForElementVisible(driver, ContacDetailsUI.MOBILE);
        clearValueInTextbox(driver, ContacDetailsUI.MOBILE);
        sendkeyToElement(driver,ContacDetailsUI.MOBILE,mobile);
    }

    public void enterWork(String work) {
        waitForElementVisible(driver, ContacDetailsUI.WORK);
        clearValueInTextbox(driver, ContacDetailsUI.WORK);
        sendkeyToElement(driver,ContacDetailsUI.WORK,work);
    }

    public void enterWorkEmail(String workEmail) {
        waitForElementVisible(driver, ContacDetailsUI.WORK_EMAIL);
        clearValueInTextbox(driver, ContacDetailsUI.WORK_EMAIL);
        sendkeyToElement(driver,ContacDetailsUI.WORK_EMAIL,workEmail);
    }

    public void enterOtherEmail(String otherEmail) {
        waitForElementVisible(driver, ContacDetailsUI.OTHER_EMAIL);
        clearValueInTextbox(driver, ContacDetailsUI.OTHER_EMAIL);
        sendkeyToElement(driver,ContacDetailsUI.OTHER_EMAIL,otherEmail);
    }

    public void clickToSaveButton() {
        waitForElementClickable(driver,ContacDetailsUI.SAVE_CONTACT_BUTTON);
        clickToElement(driver,ContacDetailsUI.SAVE_CONTACT_BUTTON);
        waitForSuccessMessageDisplayed(driver);

    }
    public void enterContactDetailsInfo(ContactDetailsJson contactDetailsData){
        enterStreet1(contactDetailsData.getStreet1());
        enterStreet2(contactDetailsData.getStreet2());
        enterCity(contactDetailsData.getCity());
        enterStateProvince(contactDetailsData.getStateProvince());
        enterZipPostalCode(contactDetailsData.getZipPostalCode());
        selectCountry(contactDetailsData.getCountry());
        enterHome(contactDetailsData.getHome());
        enterMobile(contactDetailsData.getMobile());
        enterWork(contactDetailsData.getWork());
        enterOtherEmail(contactDetailsData.getOtherEmail());
    }

}
