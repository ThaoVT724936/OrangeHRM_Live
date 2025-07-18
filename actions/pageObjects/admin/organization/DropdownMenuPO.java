package pageObjects.admin.organization;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.admin.job.DropdownMenuUI;

public class DropdownMenuPO extends BasePage {
    public DropdownMenuPO(WebDriver driver) {
        super(driver);
    }

    public void clickOnJobTab(){
        waitForElementClickable(driver, DropdownMenuUI.JOB_BUTTON);
        clickToElement(driver,DropdownMenuUI.JOB_BUTTON);
    }

    public JobTitlesPO openJobTitlesPO(){
        clickOnJobTab();
        waitForElementClickable(driver,DropdownMenuUI.JOB_TITLES_MENU);
        clickToElement(driver,DropdownMenuUI.JOB_TITLES_MENU);
        return PageGenerator.getJobTitlesPO(driver);
    }

    public PayGradesPO openPayGradesPO(){
        clickOnJobTab();
        waitForElementClickable(driver,DropdownMenuUI.PAY_GRADES_MENU);
        clickToElement(driver,DropdownMenuUI.PAY_GRADES_MENU);
        return PageGenerator.getPayGradesPO(driver);
    }

    public EmploymentStatusPO openEmploymentStatusPO(){
        clickOnJobTab();
        waitForElementClickable(driver,DropdownMenuUI.EMPLOYMENT_STATUS_MENU);
        clickToElement(driver,DropdownMenuUI.EMPLOYMENT_STATUS_MENU);
        return PageGenerator.getEmploymentStatusPO(driver);
    }

    public JobCategoriesPO openJobCategoriesPO(){
        clickOnJobTab();
        waitForElementClickable(driver,DropdownMenuUI.JOB_CATEGORIES_MENU);
        clickToElement(driver,DropdownMenuUI.JOB_CATEGORIES_MENU);
        return PageGenerator.getJobCategoriesPO(driver);
    }

    public WorkShiftsPO openWorkShiftsPO(){
        clickOnJobTab();
        waitForElementClickable(driver,DropdownMenuUI.WORK_SHIFTS_MENU);
        clickToElement(driver,DropdownMenuUI.WORK_SHIFTS_MENU);
        return PageGenerator.getWorkShiftsPO(driver);
    }

}
