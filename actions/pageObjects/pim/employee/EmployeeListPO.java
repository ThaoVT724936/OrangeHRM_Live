package pageObjects.pim.employee;

import commons.BasePage;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.PageGenerator;
import pageUIs.PIM.employee.EmployeeListUI;
import pageUIs.PIM.employee.PersonalDetailsUI;

import java.util.List;

public class EmployeeListPO extends BasePage {
    private WebDriver driver;
    public EmployeeListPO(WebDriver driver){
        this.driver = driver;
    }

    public AddNewEmployeePO clickToAddEmployeeTab() {
        waitForElementClickable(driver, EmployeeListUI.ADD_EMPLOYEE_TAB);
        clickToElement(driver,EmployeeListUI.ADD_EMPLOYEE_TAB);
        return PageGenerator.getAddNewEmployeePO(driver);
    }

/*    public PersonalDetailsPO clickToEditButtonInTable(String id){
        waitForElementClickable(driver,EmployeeListUI.EDIT_BUTTON_IN_TABLE,id);
        clickToElement(driver,EmployeeListUI.EDIT_BUTTON_IN_TABLE,id);
        waitForIconLoadingDisappear(driver);
        return PageGenerator.getPersonalDetailsPOInEmployee(driver);
    }*/

    /*public void clickToDeleteButtonInTable(String id){
        waitForElementClickable(driver,EmployeeListUI.DELETE_BUTTON_IN_TABLE,id);
        clickToElement(driver,EmployeeListUI.DELETE_BUTTON_IN_TABLE,id);
        waitForIconLoadingDisappear(driver);
    }*/

    public String getFirstEmployeeIDInTable(){
        WebElement row = getElements(driver,EmployeeListUI.ROW_IN_TABLE).get(0);
        return row.findElements(getByLocator(EmployeeListUI.CELL_IN_ROW_TABLE)).get(1).getText();
    }

    public String getAnEmployeeIDInTable(String id){
        WebElement row = getElements(driver,EmployeeListUI.ROW_IN_TABLE).get(0);
        return row.findElements(getByLocator(EmployeeListUI.CELL_IN_ROW_TABLE)).get(1).getText();
    }

    public PersonalDetailsPO clickToEditButtonInTable(String id){
        int totalPages = getTotalPages();
        for (int page = 1; page <= totalPages; page++){
            clickToPagination(page);
            waitForIconLoadingDisappear(driver);
            if (!getElements(driver, EmployeeListUI.EMPLOYEE_ID, id).isEmpty()){
                waitForElementClickable(driver,EmployeeListUI.EDIT_BUTTON_IN_TABLE,id);
                clickToElement(driver,EmployeeListUI.EDIT_BUTTON_IN_TABLE,id);
                waitForIconLoadingDisappear(driver);
                break;
            }
        }
        return PageGenerator.getPersonalDetailsPOInEmployee(driver);
    }

    public void clickToDeleteButtonInTable(String id){
        int totalPages = getTotalPages();
        for (int page = 1; page <= totalPages; page++){
            clickToPagination(page);
            waitForIconLoadingDisappear(driver);
            if (!getElements(driver, EmployeeListUI.EMPLOYEE_ID, id).isEmpty()){
                waitForElementClickable(driver,EmployeeListUI.DELETE_BUTTON_IN_TABLE,id);
                clickToElement(driver,EmployeeListUI.DELETE_BUTTON_IN_TABLE,id);
                waitForIconLoadingDisappear(driver);
                waitForElementClickable(driver,EmployeeListUI.YES_DELETE_BUTTON);
                clickToElement(driver,EmployeeListUI.YES_DELETE_BUTTON);
                break;
            }
        }
    }

    public void clickToPagination(int pageNumber){
        waitForElementClickable(driver,EmployeeListUI.PAGE,String.valueOf(pageNumber));
        clickToElement(driver,EmployeeListUI.PAGE,String.valueOf(pageNumber));
    }

    public int getTotalPages(){
        int totalPages = 0;
        List<WebElement> pagination = getElements(driver,EmployeeListUI.PAGINATION);
        for (WebElement button:pagination){
            if(!button.getText().isBlank()){
                totalPages++;
            }
        }
        return totalPages;

    }
}
