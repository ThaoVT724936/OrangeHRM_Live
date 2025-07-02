package pageUIs.PIM.employee;

public class ContacDetailsUI {
    public static final String STREET1 = "xpath=//label[text()='Street 1']/parent::div/following-sibling::div/input";
    public static final String STREET2 = "xpath=//label[text()='Street 2']/parent::div/following-sibling::div/input";
    public static final String CITY = "xpath=//label[text()='City']/parent::div/following-sibling::div/input";
    public static final String STATE_PROVINCE = "xpath=//label[text()='State/Province']/parent::div/following-sibling::div/input";
    public static final String ZIP_POSTAL_CODE = "xpath=//label[text()='Zip/Postal Code']/parent::div/following-sibling::div/input";
    public static final String COUNTRY_BUTTON = "xpath=//label[text()='Country']/parent::div" +
            "//following-sibling::div/div";
    public static final String COUNTRY_LIST_OPTION = "xpath=//label[text()='Country']/parent::div" +
            "/following-sibling::div//div[@role='listbox']/div[@role='option']";
    public static final String HOME = "xpath=//label[text()='Home']/parent::div/following-sibling::div/input";
    public static final String MOBILE = "xpath=//label[text()='Mobile']/parent::div/following-sibling::div/input";

    public static final String WORK = "xpath=//label[text()='Work']/parent::div/following-sibling::div/input";
    public static final String WORK_EMAIL = "xpath=//label[text()='Work Email']/parent::div/following-sibling::div/input";
    public static final String OTHER_EMAIL = "xpath=//label[text()='Other Email']/parent::div/following-sibling::div/input";
    public static final String SAVE_CONTACT_BUTTON = "xpath=//button[contains(.,'Save')]";
    public static final String ADD_ATTACHMENTS_BUTTON = "xpath=//h6[text()='Attachments']//following-sibling::button";

}
