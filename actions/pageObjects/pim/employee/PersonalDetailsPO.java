package pageObjects.pim.employee;
import employeeData.EditEmployeeInfoJson;
import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageUIs.CommonUI;
import pageUIs.PIM.employee.PersonalDetailsUI;
import pageUIs.PIM.employee.SidebarEmployeeUI;

import java.awt.*;
import java.io.IOException;
import java.util.ListResourceBundle;

public class PersonalDetailsPO extends SidebarEmployeePO{
    private WebDriver driver;
    public PersonalDetailsPO(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    //get Info
    @Step("Get employeeID value")
    public String getEmployeeID(){
        waitForElementVisible(driver, PersonalDetailsUI.EMPLOYEE_ID_TEXTBOX);
        return getAttributeValue(driver,PersonalDetailsUI.EMPLOYEE_ID_TEXTBOX,"value");
    }

    @Step("Get firstname value")
    public String getFirstName(){
        waitForElementVisible(driver, PersonalDetailsUI.FIRST_NAME_TEXTBOX);
        return getAttributeValue(driver,PersonalDetailsUI.FIRST_NAME_TEXTBOX,"value");
    }

    @Step("Get middlename value")
    public String getMiddleName(){
        waitForElementVisible(driver, PersonalDetailsUI.MIDDLE_NAME_TEXTBOX);
        return getAttributeValue(driver,PersonalDetailsUI.MIDDLE_NAME_TEXTBOX,"value");
    }

    @Step("Get lastname value")
    public String getLastName(){
        waitForElementVisible(driver, PersonalDetailsUI.LAST_NAME_TEXTBOX);
        return getAttributeValue(driver,PersonalDetailsUI.LAST_NAME_TEXTBOX,"value");
    }

    @Step("Get employeeID value")
    public String getEmployeeIDInDetail(){
        waitForElementVisible(driver, PersonalDetailsUI.EMPLOYEE_ID_TEXTBOX);
        return getAttributeValue(driver,PersonalDetailsUI.EMPLOYEE_ID_TEXTBOX,"value");
    }

    @Step("Get otherID value")
    public String getOtherID(){
        waitForElementVisible(driver, PersonalDetailsUI.OTHER_ID);
        return getAttributeValue(driver,PersonalDetailsUI.OTHER_ID,"value");
    }

    @Step("Get DriverLicenseNumber value")
    public String getDriverLicenseNumber(){
        waitForElementVisible(driver, PersonalDetailsUI.DRIVER_LICENSE_NUMBER);
        return getAttributeValue(driver,PersonalDetailsUI.DRIVER_LICENSE_NUMBER,"value");
    }

    @Step("Get LicenseExpiryDate value")
    public String getLicenseExpiryDate(){
        waitForElementVisible(driver, PersonalDetailsUI.LICENSE_EXPIRY_DATE);
        return getAttributeValue(driver,PersonalDetailsUI.LICENSE_EXPIRY_DATE,"value");
    }

    @Step("Get Nationality value")
    public String getNationality(){
        waitForElementVisible(driver, PersonalDetailsUI.NATIONALITY_BUTTON);
        return getTextElement(driver,PersonalDetailsUI.NATIONALITY_BUTTON);
    }

    @Step("Get MaritalStatus value")
    public String getMaritalStatus(){
        waitForElementVisible(driver, PersonalDetailsUI.MARITAL_STATUS_BUTTON);
        return getTextElement(driver,PersonalDetailsUI.MARITAL_STATUS_BUTTON);
    }

    @Step("Get DateOfBirth value")
    public String getDateOfBirth(){
        waitForElementVisible(driver, PersonalDetailsUI.DATE_OF_BIRTH);
        return getAttributeValue(driver,PersonalDetailsUI.DATE_OF_BIRTH,"value");
    }

    @Step("Gender male is selected")
    public boolean genderMaleIsSelected(){
        waitForElementPresence(driver,PersonalDetailsUI.GENDER_MALE_FOR_VERIFY);
        return checkboxRadioIsSelected(driver,PersonalDetailsUI.GENDER_MALE_FOR_VERIFY);
    }

    @Step("Gender female is selected")
    public boolean genderFemaleIsSelected(){
        waitForElementPresence(driver,PersonalDetailsUI.GENDER_FEMALE_FOR_VERIFY);
        return checkboxRadioIsSelected(driver,PersonalDetailsUI.GENDER_FEMALE_FOR_VERIFY);
    }

    //Upload avatar
    @Step("Get avatar size")
    public Dimension getAvatarSize() {
        return getDimensionOfAvatarIcon(driver,PersonalDetailsUI.IMAGE_SIZE);
    }

    @Step("Upload new avatar: {0}")
    public void uploadAvatar(String avatar) {
        waitForElementPresence(driver,PersonalDetailsUI.UPLOAD_AVATAR);
        sendkeyToElement(driver,PersonalDetailsUI.UPLOAD_AVATAR,avatar);
    }

    @Step("Click to avatar image")
    public void clickToAvatarImage() {
        waitForElementClickable(driver,PersonalDetailsUI.AVATAR_IMAGE);
        clickToElement(driver,PersonalDetailsUI.AVATAR_IMAGE);
    }

    @Step("Click to Save image button")
    public void clickToSaveImageButton() {
        waitForElementClickable(driver,PersonalDetailsUI.SAVE_IMAGE_BUTTON);
        clickToElement(driver,PersonalDetailsUI.SAVE_IMAGE_BUTTON);
        waitForSuccessMessageDisplayed(driver);
    }

    //Edit personal detail
    @Step("Enter firstname to edit: {0}")
    public void enterFirstName(String firstName) {
        waitForElementClickable(driver,PersonalDetailsUI.FIRST_NAME_TEXTBOX);
        clearValueInTextbox(driver,PersonalDetailsUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver,PersonalDetailsUI.FIRST_NAME_TEXTBOX,firstName);
    }

    @Step("Enter middlename to edit: {0}")
    public void enterMiddleName(String middleName) {
        waitForElementClickable(driver,PersonalDetailsUI.MIDDLE_NAME_TEXTBOX);
        clearValueInTextbox(driver,PersonalDetailsUI.MIDDLE_NAME_TEXTBOX);
        sendkeyToElement(driver,PersonalDetailsUI.MIDDLE_NAME_TEXTBOX,middleName);
    }

    @Step("Enter lastname to edit: {0}")
    public void enterLastName(String lastName) {
        waitForElementClickable(driver,PersonalDetailsUI.LAST_NAME_TEXTBOX);
        clearValueInTextbox(driver,PersonalDetailsUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver,PersonalDetailsUI.LAST_NAME_TEXTBOX,lastName);
    }

    @Step("Enter DriverLicenseNumber to edit: {0}")
    public void enterDriverLicenseNumber(String driverLicenseNumber) {
        waitForElementClickable(driver,PersonalDetailsUI.DRIVER_LICENSE_NUMBER);
        sendkeyToElement(driver,PersonalDetailsUI.DRIVER_LICENSE_NUMBER,driverLicenseNumber);

    }

    @Step("Enter LicenseExpiryDate to edit: {0}")
    public void selectLicenseExpiryDate(String licenseExpire) {
        waitForElementClickable(driver,PersonalDetailsUI.LICENSE_EXPIRY_DATE);
        sendkeyToElement(driver,PersonalDetailsUI.LICENSE_EXPIRY_DATE,licenseExpire);

    }

    @Step("Select Nationality to edit: {0}")
    public void selectNationality(String selectItem) {
        waitForElementVisible(driver,PersonalDetailsUI.NATIONALITY_BUTTON);
        waitForElementClickable(driver,PersonalDetailsUI.NATIONALITY_BUTTON);
        clickToElement(driver,PersonalDetailsUI.NATIONALITY_BUTTON);
        selectItemInCustomDropdown(driver,PersonalDetailsUI.NATIONALITY_LIST_OPTION,selectItem);
    }

    @Step("Enter MaritalStatus to edit: {0}")
    public void selectMaritalStatus(String selectItem) {
        waitForElementVisible(driver,PersonalDetailsUI.MARITAL_STATUS_BUTTON);
        waitForElementClickable(driver,PersonalDetailsUI.MARITAL_STATUS_BUTTON);
        clickToElement(driver,PersonalDetailsUI.MARITAL_STATUS_BUTTON);
        selectItemInCustomDropdown(driver,PersonalDetailsUI.MARITAL_STATUS_LIST_OPTION,selectItem);
    }

    @Step("Enter DateOfBirth to edit: {0}")
    public void selectDateOfBirth(String dateOfBirth) {
        waitForElementClickable(driver,PersonalDetailsUI.DATE_OF_BIRTH);
        sendkeyToElement(driver,PersonalDetailsUI.DATE_OF_BIRTH,dateOfBirth);
    }
    @Step("Enter employee info for modify")
    public void enterEmployeeInfo(EditEmployeeInfoJson editEmployeeInfoData) {
        enterFirstName(editEmployeeInfoData.getEditFirstName());
        enterMiddleName(editEmployeeInfoData.getEditMiddleName());
        enterLastName(editEmployeeInfoData.getEditLastName());
        enterDriverLicenseNumber(editEmployeeInfoData.getEditDriverLicenseNumber());
        selectLicenseExpiryDate(editEmployeeInfoData.getEditLicenseExpiryDate());
        selectNationality(editEmployeeInfoData.getEditNationality());
        selectMaritalStatus(editEmployeeInfoData.getEditMaritalStatus());
        selectDateOfBirth(editEmployeeInfoData.getEditDateOfBirth());
    }

    @Step("Select radio GenderMale to edit")
    public void selectRadioGenderMale() {
        waitForElementClickable(driver,PersonalDetailsUI.GENDER_MALE_FOR_CLICK);
        checkToCheckboxAndRadio(driver,PersonalDetailsUI.GENDER_MALE_FOR_CLICK);
    }

    @Step("Click to Save Info button")
    public void clickToSaveInfoButton() {
        waitForElementClickable(driver,PersonalDetailsUI.SAVE_INFO_BUTTON);
        clickToElement(driver,PersonalDetailsUI.SAVE_INFO_BUTTON);
        waitForSuccessMessageDisplayed(driver);
    }

    @Step("Get genderCode")
    public String getGenderCode() {
        if(genderMaleIsSelected()){
            return getAttributeValue(driver,PersonalDetailsUI.GENDER_MALE_FOR_VERIFY,"value");
        }
        else if(genderFemaleIsSelected()){
            return getAttributeValue(driver,PersonalDetailsUI.GENDER_FEMALE_FOR_VERIFY,"value");
        }
        else return "0";
    }
}
