package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.pim.employee.*;
import pageUIs.MainMenuUI;
import pageUIs.PIM.employee.SidebarEmployeeUI;

public class MainMenuPO extends BasePage {
/*
    private WebDriver driver;
*/
    public MainMenuPO(WebDriver driver){
        super(driver);
/*
        this.driver = driver;
*/
    }
    public EmployeeListPO clickToPIMPage(WebDriver driver){
        waitForElementClickable(driver, MainMenuUI.PIM_MENU);
        clickToElement(driver,MainMenuUI.PIM_MENU);
        return PageGenerator.getEmployeeListPO(driver);
    }
    public DashboardPO clickToDashboardPage(WebDriver driver){
        waitForElementClickable(driver, MainMenuUI.DASHBOARD_MENU);
        clickToElement(driver,MainMenuUI.DASHBOARD_MENU);
        return PageGenerator.getDashboardPO(driver);
    }
    public EmergencyContactsPO openEmergencyContacts(WebDriver driver){
        waitForElementClickable(driver, SidebarEmployeeUI.EMERGENCY_CONTACTS_MENU);
        clickToElement(driver,SidebarEmployeeUI.EMERGENCY_CONTACTS_MENU);
        return PageGenerator.getEmergencyContactsPOInEmployee(driver);
    }
    public DependentsPO openDependents(WebDriver driver){
        waitForElementClickable(driver, SidebarEmployeeUI.DEPENDENTS_MENU);
        clickToElement(driver,SidebarEmployeeUI.DEPENDENTS_MENU);
        return PageGenerator.getDependentsPOInEmployee(driver);
    }
    public ImmigrationPO openImmigration(WebDriver driver){
        waitForElementClickable(driver, SidebarEmployeeUI.IMMIGRATION_MENU);
        clickToElement(driver,SidebarEmployeeUI.IMMIGRATION_MENU);
        return PageGenerator.getImmigrationPOInEmployee(driver);
    }
    public JobPO openJob(WebDriver driver){
        waitForElementClickable(driver, SidebarEmployeeUI.JOB_MENU);
        clickToElement(driver,SidebarEmployeeUI.JOB_MENU);
        return PageGenerator.getJobPOInEmployee(driver);
    }
    public SalaryPO openSalary(WebDriver driver){
        waitForElementClickable(driver, SidebarEmployeeUI.SALARY_MENU);
        clickToElement(driver,SidebarEmployeeUI.SALARY_MENU);
        return PageGenerator.getSalaryPOInEmployee(driver);
    }
    public ReportToPO openReportTo(WebDriver driver){
        waitForElementClickable(driver, SidebarEmployeeUI.REPORT_TO_MENU);
        clickToElement(driver,SidebarEmployeeUI.REPORT_TO_MENU);
        return PageGenerator.getReportToPOInEmployee(driver);
    }
    public QualificationsPO openQualifications(WebDriver driver){
        waitForElementClickable(driver, SidebarEmployeeUI.QUALIFICATIONS_MENU);
        clickToElement(driver,SidebarEmployeeUI.QUALIFICATIONS_MENU);
        return PageGenerator.getQualificationsPOInEmployee(driver);
    }
    public MembershipsPO openMemberships(WebDriver driver){
        waitForElementClickable(driver, SidebarEmployeeUI.MEMBERSHIPS_MENU);
        clickToElement(driver,SidebarEmployeeUI.MEMBERSHIPS_MENU);
        return PageGenerator.getMembershipsPOInEmployee(driver);
    }
}
