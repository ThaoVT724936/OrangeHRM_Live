package pageUIs.PIM.employee;

public class EmployeeListUI {
    public static final String ADD_EMPLOYEE_TAB = "xpath=//a[text()='Add Employee']";
    public static final String EDIT_BUTTON_IN_TABLE = "xpath=//div[text()= '%s']/parent::div//following-sibling::div//i[@class='oxd-icon bi-pencil-fill']/parent::button";
    public static final String DELETE_BUTTON_IN_TABLE = "xpath=//div[text()= '%s']/parent::div//following-sibling::div//i[@class='oxd-icon bi-trash']/parent::button";
    public static final String ROW_IN_TABLE = "xpath=//div[@class='oxd-table-body']//div[@role='row']";
    public static final String CELL_IN_ROW_TABLE = "xpath=//div[@class='oxd-table-body']//div[@role='row']//div[@role='cell']";
    public static final String EMPLOYEE_ID = "xpath=//div[@role = 'row']//div[text()= '%s']";
    public static final String PAGINATION = "xpath=//nav[@aria-label='Pagination Navigation']//button";
    public static final String PAGE = "xpath=//nav[@aria-label='Pagination Navigation']//button[text()='%s']";
    public static final String YES_DELETE_BUTTON = "xpath=//button[contains(.,'Yes, Delete')]";

}
