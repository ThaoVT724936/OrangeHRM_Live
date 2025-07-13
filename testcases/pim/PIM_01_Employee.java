package pim;

import com.beust.ah.A;
import commons.BaseTest;
import commons.GlobalConstants;

import employeeData.AddEmployeeJson;
import employeeData.ContactDetailsJson;
import employeeData.EditEmployeeInfoJson;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.DashboardPO;
import pageObjects.LoginPO;
import pageObjects.PageGenerator;
import pageObjects.pim.employee.AddNewEmployeePO;
import pageObjects.pim.employee.ContactDetailsPO;
import pageObjects.pim.employee.EmployeeListPO;
import pageObjects.pim.employee.PersonalDetailsPO;
import ultilities.AssertHelper;
import ultilities.DBHelper;
import ultilities.DataHelper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.server.LogStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;


public class PIM_01_Employee extends BaseTest {
    private final Logger log = LogManager.getLogger(getClass());
    private WebDriver driver;
    private LoginPO LoginPage;
    private DashboardPO DashboardPage;
    private EmployeeListPO EmployeeListPage;
    private AddNewEmployeePO AddNewEmployeePage;
    private PersonalDetailsPO PersonalDetailsPage;
    private ContactDetailsPO ContactDetailsPage;
    private AddEmployeeJson addNewEmployeeData;
    private EditEmployeeInfoJson editEmployeeInfoData;
    private ContactDetailsJson contactDetailsData;
    private String employeeID;


    private String avatar1 = GlobalConstants.UPLOAD_FILE + "image1.png";
    private String avatar2 = GlobalConstants.UPLOAD_FILE + "image2.png";
    private String workEmail;
    private String sqlEmployeeInfo = "Select * from hs_hr_employee where employee_id = ?";


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserName(browserName);
        LoginPage = PageGenerator.getLoginPO(driver);
        LoginPage.enterUserName(GlobalConstants.userName);
        LoginPage.enterPassword(GlobalConstants.password);
        DashboardPage = LoginPage.clickToLoginButton();
        addNewEmployeeData = AddEmployeeJson.getAddEmployeeData();
        editEmployeeInfoData = EditEmployeeInfoJson.getEditEmployeeData();
        contactDetailsData = ContactDetailsJson.getContactDetailsData();
        workEmail = !contactDetailsData.getWorkEmail().isEmpty() ? contactDetailsData.getWorkEmail() + DataHelper.randomNumber() + "@gmail.com" : "";

    }

    @Test
    public void Employee_01_AddNewEmployee() {
        log.info("Init EmployeeListPage");
        EmployeeListPage = DashboardPage.clickToPIMPage(driver);
        log.info("Init AddNewEmployeePage");
        AddNewEmployeePage = EmployeeListPage.clickToAddEmployeeTab();
        log.info("Enter info");
        AddNewEmployeePage.enterFirstName(addNewEmployeeData.getFirstName());
        AddNewEmployeePage.enterMiddleName(addNewEmployeeData.getMiddleName());
        AddNewEmployeePage.enterLastName(addNewEmployeeData.getLastName());
        //AddNewEmployeePage.uploadAvatar(avatar1);
        log.info("Assign value for employeeID");
        employeeID = AddNewEmployeePage.getEmployeeID();
        log.info("Click Save button");
        PersonalDetailsPage = AddNewEmployeePage.clickToSaveButton();

        log.info("Check success message is dislpayed");
        Assert.assertEquals(PersonalDetailsPage.getSuccessMessage(driver), "Successfully Saved");

        log.info("Compare value in the screen with entered value");
        Assert.assertEquals(addNewEmployeeData.getFirstName(), PersonalDetailsPage.getFirstName());
        Assert.assertEquals(addNewEmployeeData.getMiddleName(), PersonalDetailsPage.getMiddleName());
        Assert.assertEquals(addNewEmployeeData.getLastName(), PersonalDetailsPage.getLastName());
        Assert.assertEquals(employeeID, PersonalDetailsPage.getEmployeeIDInDetail());

        log.info("Compare entered value with DB");
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sqlEmployeeInfo);
        ){
            stmt.setString(1,employeeID);
            try (ResultSet resultSet = stmt.executeQuery()){
                while (resultSet.next()){
                    Assert.assertEquals(resultSet.getString("emp_firstname"),addNewEmployeeData.getFirstName());
                    Assert.assertEquals(resultSet.getString("emp_middle_name"),addNewEmployeeData.getMiddleName());
                    Assert.assertEquals(resultSet.getString("emp_lastname"),addNewEmployeeData.getLastName());
                }
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }

    }
/*

    @Test
    public void Employee_02_UploadAvatar() {
        EmployeeListPage = DashboardPage.clickToPIMPage(driver);
        System.out.println(EmployeeListPage.getTotalPages());
        PersonalDetailsPage = EmployeeListPage.clickToEditButtonInTable(employeeID);

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
        EmployeeListPage = DashboardPage.clickToPIMPage(driver);
        PersonalDetailsPage = EmployeeListPage.clickToEditButtonInTable(employeeID);

        PersonalDetailsPage.waitForIconLoadingDisappear(driver);
        PersonalDetailsPage.enterEmployeeInfo(editEmployeeInfoData);
        PersonalDetailsPage.selectRadioGenderMale();
        PersonalDetailsPage.clickToSaveInfoButton();

        Assert.assertEquals(PersonalDetailsPage.getSuccessMessage(driver), "Successfully Updated");

        PersonalDetailsPage.waitForIconLoadingDisappear(driver);

        Assert.assertEquals(PersonalDetailsPage.getFirstName(), editEmployeeInfoData.getEditFirstName());
        Assert.assertEquals(PersonalDetailsPage.getMiddleName(), editEmployeeInfoData.getEditMiddleName());
        Assert.assertEquals(PersonalDetailsPage.getLastName(), editEmployeeInfoData.getEditLastName());
        Assert.assertEquals(PersonalDetailsPage.getDriverLicenseNumber(), editEmployeeInfoData.getEditDriverLicenseNumber());
        Assert.assertEquals(PersonalDetailsPage.getLicenseExpiryDate(), editEmployeeInfoData.getEditLicenseExpiryDate());
        Assert.assertEquals(PersonalDetailsPage.getNationality(), editEmployeeInfoData.getEditNationality());
        Assert.assertEquals(PersonalDetailsPage.getMaritalStatus(), editEmployeeInfoData.getEditMaritalStatus());
        Assert.assertEquals(PersonalDetailsPage.getDateOfBirth(), editEmployeeInfoData.getEditDateOfBirth());
        Assert.assertTrue(PersonalDetailsPage.genderMaleIsSelected());

        String sqlNationCode = "Select * from ohrm_nationality where name = ?";
        try (Connection cnn = DBHelper.getConnection();
             PreparedStatement statementNationCode = cnn.prepareStatement(sqlNationCode);
             PreparedStatement statementEmployeeInfo = cnn.prepareStatement(sqlEmployeeInfo);
        ) {
            statementNationCode.setString(1, editEmployeeInfoData.getEditNationality());
            try (ResultSet rsNationCode = statementNationCode.executeQuery()) {
                if (rsNationCode.next()) {
                    statementEmployeeInfo.setString(1, PersonalDetailsPage.getEmployeeID());
                    String nationCode = rsNationCode.getString("id");
                    try (ResultSet rsEmployeeInfo = statementEmployeeInfo.executeQuery()) {
                        while (rsEmployeeInfo.next()) {
                            AssertHelper.assertEquals(rsEmployeeInfo.getString("emp_firstname"), editEmployeeInfoData.getEditFirstName());
                            AssertHelper.assertEquals(rsEmployeeInfo.getString("emp_middle_name"), editEmployeeInfoData.getEditMiddleName());
                            AssertHelper.assertEquals(rsEmployeeInfo.getString("emp_lastname"), editEmployeeInfoData.getEditLastName());
                            AssertHelper.assertEquals(rsEmployeeInfo.getString("nation_code"), nationCode);
                            AssertHelper.assertEquals(rsEmployeeInfo.getString("emp_gender"), PersonalDetailsPage.getGenderCode());
                            AssertHelper.assertEquals(rsEmployeeInfo.getString("emp_birthday"), editEmployeeInfoData.getEditDateOfBirth());
                            AssertHelper.assertEquals(rsEmployeeInfo.getString("emp_marital_status"), editEmployeeInfoData.getEditMaritalStatus());
                            AssertHelper.assertEquals(rsEmployeeInfo.getString("emp_dri_lice_num"), editEmployeeInfoData.getEditDriverLicenseNumber());
                            AssertHelper.assertEquals(rsEmployeeInfo.getString("emp_dri_lice_exp_date"), editEmployeeInfoData.getEditLicenseExpiryDate());
                        }
                    }
                } else {
                    Assert.fail("National code not found!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Employee_04_Contact_Details() {
        EmployeeListPage = DashboardPage.clickToPIMPage(driver);
        PersonalDetailsPage = EmployeeListPage.clickToEditButtonInTable(employeeID);

        ContactDetailsPage = PersonalDetailsPage.openContactDetails(driver);
        ContactDetailsPage.waitForIconLoadingDisappear(driver);
        ContactDetailsPage.enterContactDetailsInfo(contactDetailsData);
        ContactDetailsPage.enterWorkEmail(workEmail);
        ContactDetailsPage.clickToSaveButton();

        Assert.assertEquals(ContactDetailsPage.getSuccessMessage(driver), "Successfully Updated");

        ContactDetailsPage.waitForIconLoadingDisappear(driver);

        Assert.assertEquals(ContactDetailsPage.getStreet1(), contactDetailsData.getStreet1());
        Assert.assertEquals(ContactDetailsPage.getStreet2(), contactDetailsData.getStreet2());
        Assert.assertEquals(ContactDetailsPage.getCity(), contactDetailsData.getCity());
        Assert.assertEquals(ContactDetailsPage.getStateProvince(), contactDetailsData.getStateProvince());
        Assert.assertEquals(ContactDetailsPage.getZipPostalCode(), contactDetailsData.getZipPostalCode());
        Assert.assertEquals(ContactDetailsPage.getCountry(), contactDetailsData.getCountry());
        Assert.assertEquals(ContactDetailsPage.getHome(), contactDetailsData.getHome());
        Assert.assertEquals(ContactDetailsPage.getMobile(), contactDetailsData.getMobile());
        Assert.assertEquals(ContactDetailsPage.getWork(), contactDetailsData.getWork());
        Assert.assertEquals(ContactDetailsPage.getWorkEmail(), workEmail);
        Assert.assertEquals(ContactDetailsPage.getOtherEmail(), contactDetailsData.getOtherEmail());

        String sqlCountryCode = "Select * from hs_hr_country where cou_name = ?";
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement statementEmployeeInfo = connection.prepareStatement(sqlEmployeeInfo);
             PreparedStatement statementCountryCode = connection.prepareStatement(sqlCountryCode);
        ){
            statementCountryCode.setString(1,contactDetailsData.getCountry());
            try (ResultSet countryCodeResultSet = statementCountryCode.executeQuery()){
                if (countryCodeResultSet.next()){
                    statementEmployeeInfo.setString(1,employeeID);
                    String countryCode = countryCodeResultSet.getString("cou_code");
                    try (ResultSet employeeResultSet = statementEmployeeInfo.executeQuery()){
                        while (employeeResultSet.next()){
                            AssertHelper.assertEquals(employeeResultSet.getString("emp_street1"),contactDetailsData.getStreet1());
                            AssertHelper.assertEquals(employeeResultSet.getString("emp_street2"),contactDetailsData.getStreet2());
                            AssertHelper.assertEquals(employeeResultSet.getString("city_code"),contactDetailsData.getCity());
                            AssertHelper.assertEquals(employeeResultSet.getString("provin_code"),contactDetailsData.getStateProvince());
                            AssertHelper.assertEquals(employeeResultSet.getString("emp_zipcode"),contactDetailsData.getZipPostalCode());
                            AssertHelper.assertEquals(employeeResultSet.getString("coun_code"), countryCode);
                            AssertHelper.assertEquals(employeeResultSet.getString("emp_hm_telephone"),contactDetailsData.getHome());
                            AssertHelper.assertEquals(employeeResultSet.getString("emp_mobile"),contactDetailsData.getMobile());
                            AssertHelper.assertEquals(employeeResultSet.getString("emp_work_telephone"),contactDetailsData.getWork());
                            AssertHelper.assertEquals(employeeResultSet.getString("emp_work_email"),workEmail);
                            AssertHelper.assertEquals(employeeResultSet.getString("emp_oth_email"), contactDetailsData.getOtherEmail());
                        }
                    }
                }
                else {
                    Assert.fail("Country code not found!");
                }
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
*/
    @AfterMethod
    public void afterMethod() throws IOException {
        Path logDir = Paths.get("logs");
        Path latestLogFile = Files.list(logDir)
                .filter(Files::isRegularFile)
                .max(Comparator.comparingLong(f -> f.toFile().lastModified()))
                .orElse(null);

        if (latestLogFile != null) {
            Allure.addAttachment("Log File", new FileInputStream(latestLogFile.toFile()));
        } else {
            System.out.println("Không tìm thấy file log để attach vào Allure report.");
        }
    }

    @AfterClass
    public void afterClass() {
        EmployeeListPage = DashboardPage.clickToPIMPage(driver);
        EmployeeListPage.clickToDeleteButtonInTable(employeeID);
    }
}
