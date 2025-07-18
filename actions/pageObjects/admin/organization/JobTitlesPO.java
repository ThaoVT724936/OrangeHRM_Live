package pageObjects.admin.organization;

import org.openqa.selenium.WebDriver;
import pageUIs.admin.job.JobTitlesUI;

public class JobTitlesPO extends DropdownMenuPO{
    public JobTitlesPO(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddButton(){
        waitForElementClickable(driver, JobTitlesUI.ADD_BUTTON);
    }
}
