package pim;

import commons.BaseTest;
import commons.GlobalConstants;

import employeeData.AddEmployeeJson;
import employeeData.EditEmployeeInfoJson;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.DashboardPO;
import pageObjects.LoginPO;
import pageObjects.PageGenerator;
import pageObjects.pim.employee.AddNewEmployeePO;
import pageObjects.pim.employee.EmployeeListPO;
import pageObjects.pim.employee.PersonalDetailsPO;
import ultilities.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PIM_01_Employee extends BaseTest {
    private WebDriver driver;
    private LoginPO LoginPage;
    private DashboardPO DashboardPage;
    private EmployeeListPO EmployeeListPage;
    private AddNewEmployeePO AddNewEmployeePage;
    private PersonalDetailsPO PersonalDetailsPage;
    private AddEmployeeJson addNewEmployeeData;
    private EditEmployeeInfoJson editEmployeeInfoData;
    private String employeeID;


    private String avatar1 = GlobalConstants.UPLOAD_FILE + "image1.png";
    private String avatar2 = GlobalConstants.UPLOAD_FILE + "image2.png";

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        driver = getBrowserName(browserName, url);
        LoginPage = PageGenerator.getLoginPO(driver);
        LoginPage.enterUserName(GlobalConstants.userName);
        LoginPage.enterPassword(GlobalConstants.password);
        DashboardPage = LoginPage.clickToLoginButton();
        addNewEmployeeData = AddEmployeeJson.getAddEmployeeData();
        editEmployeeInfoData = EditEmployeeInfoJson.getEditEmployeeData();
    }
    @Test
    public void Employee_01_AddNewEmployee(){
        EmployeeListPage = DashboardPage.clickToPIMPage(driver);
        AddNewEmployeePage = EmployeeListPage.clickToAddEmployeeTab();
        AddNewEmployeePage.enterFirstName(addNewEmployeeData.getFirstName());
        AddNewEmployeePage.enterMiddleName(addNewEmployeeData.getMiddleName());
        AddNewEmployeePage.enterLastName(addNewEmployeeData.getLastName());
        //AddNewEmployeePage.uploadAvatar(avatar1);
        employeeID = AddNewEmployeePage.getEmployeeID();
        PersonalDetailsPage = AddNewEmployeePage.clickToSaveButton();

        Assert.assertEquals(PersonalDetailsPage.getSuccessMessage(driver), "Successfully Saved");

        Assert.assertEquals(addNewEmployeeData.getFirstName(),PersonalDetailsPage.getFirstName());
        Assert.assertEquals(addNewEmployeeData.getMiddleName(),PersonalDetailsPage.getMiddleName());
        Assert.assertEquals(addNewEmployeeData.getLastName(),PersonalDetailsPage.getLastName());
        Assert.assertEquals(employeeID,PersonalDetailsPage.getEmployeeIDInDetail());

    }
    @Test
    public void Employee_02_UploadAvatar(){
        Dimension avatarSizeBefore = PersonalDetailsPage.getAvatarSize();

        PersonalDetailsPage.waitForIconLoadingDisappear(driver);
        PersonalDetailsPage.clickToAvatarImage();
        PersonalDetailsPage.uploadAvatar(avatar1);
        PersonalDetailsPage.clickToSaveImageButton();

        Assert.assertEquals(PersonalDetailsPage.getSuccessMessage(driver), "Successfully Updated");

        PersonalDetailsPage.waitForIconLoadingDisappear(driver);
        Dimension avatarSizeAfter = PersonalDetailsPage.getAvatarSize();

        System.out.println("before is " + avatarSizeBefore + " and after is " + avatarSizeAfter);
        Assert.assertTrue(!avatarSizeBefore.equals(avatarSizeAfter));

    }

    @Test
    public void Employee_03_Edit_Personal_Details() {
        PersonalDetailsPage.openPersonalDetails(driver);
        PersonalDetailsPage.waitForIconLoadingDisappear(driver);
        PersonalDetailsPage.enterEmployeeInfo(editEmployeeInfoData);
        PersonalDetailsPage.selectRadioGenderMale();
        PersonalDetailsPage.clickToSaveInfoButton();

        Assert.assertEquals(PersonalDetailsPage.getSuccessMessage(driver), "Successfully Updated");

        PersonalDetailsPage.waitForIconLoadingDisappear(driver);

        Assert.assertEquals(PersonalDetailsPage.getFirstName(),editEmployeeInfoData.getEditFirstName());
        Assert.assertEquals(PersonalDetailsPage.getMiddleName(),editEmployeeInfoData.getEditMiddleName());
        Assert.assertEquals(PersonalDetailsPage.getLastName(),editEmployeeInfoData.getEditLastName());
        Assert.assertEquals(PersonalDetailsPage.getDriverLicenseNumber(),editEmployeeInfoData.getEditDriverLicenseNumber());
        Assert.assertEquals(PersonalDetailsPage.getLicenseExpiryDate(),editEmployeeInfoData.getEditLicenseExpiryDate());
        Assert.assertEquals(PersonalDetailsPage.getNationality(),editEmployeeInfoData.getEditNationality());
        Assert.assertEquals(PersonalDetailsPage.getMaritalStatus(),editEmployeeInfoData.getEditMaritalStatus());
        Assert.assertEquals(PersonalDetailsPage.getDateOfBirth(),editEmployeeInfoData.getEditDateOfBirth());
        Assert.assertTrue(PersonalDetailsPage.genderMaleIsSelected());

        String sqlEmployeeInfo = "Select * from hs_hr_employee where employee_id = ?";
        String sqlNationCode = "Select * from ohrm_nationality where name = ?";
        try (Connection cnn = DBHelper.getConnection();
             PreparedStatement statementNationCode = cnn.prepareStatement(sqlNationCode);
             PreparedStatement statementEmployeeInfo = cnn.prepareStatement(sqlEmployeeInfo);
             )
        {
            statementNationCode.setString(1,editEmployeeInfoData.getEditNationality());
            try (ResultSet rsNationCode = statementNationCode.executeQuery()) {
                if (rsNationCode.next()) {
                        statementEmployeeInfo.setString(1, PersonalDetailsPage.getEmployeeID());
                        String nationCode = rsNationCode.getString("id");
                        try (ResultSet rsEmployeeInfo = statementEmployeeInfo.executeQuery()) {
                            while (rsEmployeeInfo.next()) {
                                System.out.println(rsEmployeeInfo.getString("emp_firstname") +
                                        rsEmployeeInfo.getString("emp_middle_name") +
                                        rsEmployeeInfo.getString("emp_lastname") +
                                        rsEmployeeInfo.getString("emp_gender") +
                                        rsEmployeeInfo.getString("emp_birthday") +
                                        rsEmployeeInfo.getString("emp_marital_status") +
                                        rsEmployeeInfo.getString("emp_dri_lice_num") +
                                        rsEmployeeInfo.getString("emp_dri_lice_exp_date"));
                                Assert.assertEquals(rsEmployeeInfo.getString("emp_firstname"), editEmployeeInfoData.getEditFirstName());
                                Assert.assertEquals(rsEmployeeInfo.getString("emp_middle_name"), editEmployeeInfoData.getEditMiddleName());
                                Assert.assertEquals(rsEmployeeInfo.getString("emp_lastname"), editEmployeeInfoData.getEditLastName());
                                Assert.assertEquals(rsEmployeeInfo.getString("nation_code"), nationCode);
                                Assert.assertEquals(rsEmployeeInfo.getString("emp_gender"), PersonalDetailsPage.getGenderCode());
                                Assert.assertEquals(rsEmployeeInfo.getString("emp_birthday"), editEmployeeInfoData.getEditDateOfBirth());
                                Assert.assertEquals(rsEmployeeInfo.getString("emp_marital_status"), editEmployeeInfoData.getEditMaritalStatus());
                                Assert.assertEquals(rsEmployeeInfo.getString("emp_dri_lice_num"), editEmployeeInfoData.getEditDriverLicenseNumber());
                                Assert.assertEquals(rsEmployeeInfo.getString("emp_dri_lice_exp_date"), editEmployeeInfoData.getEditLicenseExpiryDate());
                            }
                        }
                }
                else
                {
                    Assert.fail("National code not found!");
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }


      /*  ResultSet rsEmployeeInfo = DBHelper.getConnection(sqlEmployeeInfo,PersonalDetailsPage.getEmployeeID());
        ResultSet rsNationCode = DBHelper.getConnection(sqlNationCode,editEmployeeInfoData.getEditNationality());
        rsNationCode.next();
        while (rsEmployeeInfo.next()){
            System.out.println(rsEmployeeInfo.getString("emp_firstname")+
                    rsEmployeeInfo.getString("emp_middle_name")+
                    rsEmployeeInfo.getString("emp_lastname")+
                    rsEmployeeInfo.getString("emp_gender")+
                    rsEmployeeInfo.getString("emp_birthday")+
                    rsEmployeeInfo.getString("emp_marital_status")+
                    rsEmployeeInfo.getString("emp_dri_lice_num")+
                    rsEmployeeInfo.getString("emp_dri_lice_exp_date"));
            Assert.assertEquals(rsEmployeeInfo.getString("emp_firstname"),editEmployeeInfoData.getEditFirstName());
            Assert.assertEquals(rsEmployeeInfo.getString("emp_middle_name"),editEmployeeInfoData.getEditMiddleName());
            Assert.assertEquals(rsEmployeeInfo.getString("emp_lastname"),editEmployeeInfoData.getEditLastName());
            Assert.assertEquals(rsEmployeeInfo.getString("nation_code"),rsNationCode.getString("id"));
            Assert.assertEquals(rsEmployeeInfo.getString("emp_gender"),PersonalDetailsPage.getGenderCode());
            Assert.assertEquals(rsEmployeeInfo.getString("emp_birthday"),editEmployeeInfoData.getEditDateOfBirth());
            Assert.assertEquals(rsEmployeeInfo.getString("emp_marital_status"),editEmployeeInfoData.getEditMaritalStatus());
            Assert.assertEquals(rsEmployeeInfo.getString("emp_dri_lice_num"),editEmployeeInfoData.getEditDriverLicenseNumber());
            Assert.assertEquals(rsEmployeeInfo.getString("emp_dri_lice_exp_date"),editEmployeeInfoData.getEditLicenseExpiryDate());

        }*/

    }

   /* @AfterClass
    public void afterClass(){
        driver.quit();
    }*/
}
