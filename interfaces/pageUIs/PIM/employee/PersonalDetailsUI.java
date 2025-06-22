package pageUIs.PIM.employee;

public class PersonalDetailsUI {
    public static final String FIRST_NAME_TEXTBOX = "css=input.orangehrm-firstname";
    public static final String MIDDLE_NAME_TEXTBOX = "css=input.orangehrm-middlename";
    public static final String LAST_NAME_TEXTBOX = "css=input.orangehrm-lastname";
    public static final String EMPLOYEE_ID_TEXTBOX = "xpath=//label[text()='Employee Id']/parent::div//following-sibling::div/input";
    public static final String AVATAR_IMAGE = "xpath=//img[@class = 'employee-image']/parent::div/parent::div";
    public static final String IMAGE_SIZE = "xpath=//img[@class = 'employee-image']";
    public static final String UPLOAD_AVATAR = "css=input.oxd-file-input";
    public static final String SAVE_IMAGE_BUTTON = "xpath=//button[contains(string(), 'Save')]";

    public static final String OTHER_ID = "xpath=//label[text()='Other Id']/parent::div//following-sibling::div/input";
    public static final String DRIVER_LICENSE_NUMBER = "xpath=//label[contains(string(),\"Driver's License Number\")]/parent::div//following-sibling::div/input";
    public static final String LICENSE_EXPIRY_DATE = "xpath=//label[contains(string(),'License Expiry Date')]/parent::div" +
            "//following-sibling::div//input";
    public static final String NATIONALITY_BUTTON = "xpath=//label[text()='Nationality']/parent::div" +
            "//following-sibling::div/div";
    public static final String NATIONALITY_LIST_OPTION = "xpath=//label[text()='Nationality']/parent::div" +
            "/following-sibling::div//div[@role='listbox']/div[@role='option']";
    public static final String MARITAL_STATUS_BUTTON = "xpath=//label[text()='Marital Status']/parent::div" +
            "//following-sibling::div/div";
    public static final String MARITAL_STATUS_LIST_OPTION = "xpath=//label[text()='Marital Status']/parent::div" +
            "/following-sibling::div//div[@role='listbox']/div[@role='option']";
    public static final String DATE_OF_BIRTH = "xpath=//label[contains(string(),'Date of Birth')]/parent::div" +
            "//following-sibling::div//input";;
    public static final String GENDER_MALE_FOR_CLICK = "xpath=//label[contains(.,'Male')]";
    public static final String GENDER_MALE_FOR_VERIFY = "xpath=//input[@type = 'radio' and @value = '1']";
    public static final String GENDER_FEMALE_FOR_CLICK = "xpath=//label[contains(.,'Female')]";
    public static final String GENDER_FEMALE_FOR_VERIFY = "xpath=//input[@type = 'radio' and @value = '2']";
    public static final String SAVE_INFO_BUTTON = "xpath=//button[contains(.,'Save')]";
    public static final String ADD_ATTACHMENTS_BUTTON = "xpath=//h6[text()='Attachments']//following-sibling::button";

}
