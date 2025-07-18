package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.admin.UserManagementPO;
import pageObjects.admin.organization.*;
import pageObjects.pim.employee.*;

public class PageGenerator extends BasePage {
    public PageGenerator(WebDriver driver){
        super(driver);
    }
    public static LoginPO getLoginPO(WebDriver driver){
        return new LoginPO(driver);
    }
    //Sidebar in Employee Details
    public static PersonalDetailsPO getPersonalDetailsPOInEmployee(WebDriver driver){
        return new PersonalDetailsPO(driver);
    }
    public static ContactDetailsPO getContactDetailsPOInEmployee(WebDriver driver){
        return new ContactDetailsPO(driver);
    }
    public static EmergencyContactsPO getEmergencyContactsPOInEmployee(WebDriver driver){
        return new EmergencyContactsPO(driver);
    }
    public static DependentsPO getDependentsPOInEmployee(WebDriver driver){
        return new DependentsPO(driver);
    }
    public static ImmigrationPO getImmigrationPOInEmployee(WebDriver driver){
        return new ImmigrationPO(driver);
    }
    public static JobPO getJobPOInEmployee(WebDriver driver){
        return new JobPO(driver);
    }
    public static SalaryPO getSalaryPOInEmployee(WebDriver driver){
        return new SalaryPO(driver);
    }
    public static ReportToPO getReportToPOInEmployee(WebDriver driver){
        return new ReportToPO(driver);
    }
    public static QualificationsPO getQualificationsPOInEmployee(WebDriver driver){
        return new QualificationsPO(driver);
    }
    public static MembershipsPO getMembershipsPOInEmployee(WebDriver driver){
        return new MembershipsPO(driver);
    }
    //Tabs in PIM
    public static AddNewEmployeePO getAddNewEmployeePO(WebDriver driver){
        return new AddNewEmployeePO(driver);
    }
    public static EmployeeListPO getEmployeeListPO(WebDriver driver){
        return new EmployeeListPO(driver);
    }
    //Main menu
    public static DashboardPO getDashboardPO(WebDriver driver){
        return new DashboardPO(driver);
    }
    public static PimPO getPimPO(WebDriver driver){
        return new PimPO(driver);
    }

    //Dropdown Menu in admin.job
    public static JobTitlesPO getJobTitlesPO(WebDriver driver){
        return new JobTitlesPO(driver);
    }
    public static PayGradesPO getPayGradesPO(WebDriver driver){
        return new PayGradesPO(driver);
    }
    public static EmploymentStatusPO getEmploymentStatusPO(WebDriver driver){
        return new EmploymentStatusPO(driver);
    }
    public static JobCategoriesPO getJobCategoriesPO(WebDriver driver){
        return new JobCategoriesPO(driver);
    }
    public static WorkShiftsPO getWorkShiftsPO(WebDriver driver){
        return new WorkShiftsPO(driver);
    }

    //Dropdown Menu in admin.user management
    public static UserManagementPO getUserManagementPO(WebDriver driver){
        return new UserManagementPO(driver);
    }

}
