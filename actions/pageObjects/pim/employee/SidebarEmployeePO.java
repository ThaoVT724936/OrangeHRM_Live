package pageObjects.pim.employee;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.PIM.employee.SidebarEmployeeUI;

public class SidebarEmployeePO extends BasePage {
/*
    private WebDriver driver;
*/
    public SidebarEmployeePO(WebDriver driver){
        super(driver);
/*
        this.driver = driver;
*/
    }

    @Step("Init PersonalDetails Page")
    public PersonalDetailsPO openPersonalDetails(WebDriver driver){
        waitForElementClickable(driver, SidebarEmployeeUI.PERSONAL_DETAILS_MENU);
        clickToElement(driver,SidebarEmployeeUI.PERSONAL_DETAILS_MENU);
        return PageGenerator.getPersonalDetailsPOInEmployee(driver);
    }

    @Step("Init ContactDetais Page")
    public ContactDetailsPO openContactDetails(WebDriver driver){
        waitForElementClickable(driver, SidebarEmployeeUI.CONTACT_DETAILS_MENU);
        clickToElement(driver,SidebarEmployeeUI.CONTACT_DETAILS_MENU);
        return PageGenerator.getContactDetailsPOInEmployee(driver);
    }

    @Step("Init EmergencyContacts Page")
    public EmergencyContactsPO openEmergencyContacts(WebDriver driver){
        waitForElementClickable(driver, SidebarEmployeeUI.EMERGENCY_CONTACTS_MENU);
        clickToElement(driver,SidebarEmployeeUI.EMERGENCY_CONTACTS_MENU);
        return PageGenerator.getEmergencyContactsPOInEmployee(driver);
    }

    @Step("Init Dependents Page")
    public DependentsPO openDependents(WebDriver driver){
        waitForElementClickable(driver, SidebarEmployeeUI.DEPENDENTS_MENU);
        clickToElement(driver,SidebarEmployeeUI.DEPENDENTS_MENU);
        return PageGenerator.getDependentsPOInEmployee(driver);
    }

    @Step("Init Immigration Page")
    public ImmigrationPO openImmigration(WebDriver driver){
        waitForElementClickable(driver, SidebarEmployeeUI.IMMIGRATION_MENU);
        clickToElement(driver,SidebarEmployeeUI.IMMIGRATION_MENU);
        return PageGenerator.getImmigrationPOInEmployee(driver);
    }

    @Step("Init Job Page")
    public JobPO openJob(WebDriver driver){
        waitForElementClickable(driver, SidebarEmployeeUI.JOB_MENU);
        clickToElement(driver,SidebarEmployeeUI.JOB_MENU);
        return PageGenerator.getJobPOInEmployee(driver);
    }

    @Step("Init Salary Page")
    public SalaryPO openSalary(WebDriver driver){
        waitForElementClickable(driver, SidebarEmployeeUI.SALARY_MENU);
        clickToElement(driver,SidebarEmployeeUI.SALARY_MENU);
        return PageGenerator.getSalaryPOInEmployee(driver);
    }

    @Step("Init ReportTo Page")
    public ReportToPO openReportTo(WebDriver driver){
        waitForElementClickable(driver, SidebarEmployeeUI.REPORT_TO_MENU);
        clickToElement(driver,SidebarEmployeeUI.REPORT_TO_MENU);
        return PageGenerator.getReportToPOInEmployee(driver);
    }

    @Step("Init Qualifications Page")
    public QualificationsPO openQualifications(WebDriver driver){
        waitForElementClickable(driver, SidebarEmployeeUI.QUALIFICATIONS_MENU);
        clickToElement(driver,SidebarEmployeeUI.QUALIFICATIONS_MENU);
        return PageGenerator.getQualificationsPOInEmployee(driver);
    }

    @Step("Init Memberships Page")
    public MembershipsPO openMemberships(WebDriver driver){
        waitForElementClickable(driver, SidebarEmployeeUI.MEMBERSHIPS_MENU);
        clickToElement(driver,SidebarEmployeeUI.MEMBERSHIPS_MENU);
        return PageGenerator.getMembershipsPOInEmployee(driver);
    }
}
