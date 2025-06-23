package employeeData;

import commons.GlobalConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.File;

public class EditEmployeeInfoJson {
    @JsonProperty("editFirstName")
    String editFirstName;

    @JsonProperty("editMiddleName")
    String editMiddleName;

    @JsonProperty("editLastName")
    String editLastName;

    @JsonProperty("editOtherID")
    String editOtherID;

    @JsonProperty("editDriverLicenseNumber")
    String editDriverLicenseNumber;

    @JsonProperty("editLicenseExpiryDate")
    String editLicenseExpiryDate;

    @JsonProperty("editNationality")
    String editNationality;

    @JsonProperty("editMaritalStatus")
    String editMaritalStatus;

    @JsonProperty("editDateOfBirth")
    String editDateOfBirth;

    public static EditEmployeeInfoJson getEditEmployeeData(){
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new File(GlobalConstants.JSON_DATA_PATH + "editEmployeeInfo.json")
                    , EditEmployeeInfoJson.class);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public String getEditFirstName() {
        return editFirstName;
    }

    public String getEditLastName() {
        return editLastName;
    }

    public String getEditMiddleName() {
        return editMiddleName;
    }

    public String getEditOtherID() {
        return editOtherID;
    }

    public String getEditDriverLicenseNumber() {
        return editDriverLicenseNumber;
    }

    public String getEditLicenseExpiryDate() {
        return editLicenseExpiryDate;
    }

    public String getEditNationality() {
        return editNationality;
    }

    public String getEditMaritalStatus() {
        return editMaritalStatus;
    }

    public String getEditDateOfBirth() {
        return editDateOfBirth;
    }
   /* @DataProvider(name = "editEmployeeData")
    public static Object[][] getEditEmployeeData(){
        try{
            ObjectMapper mapper = new ObjectMapper();
            List<EditEmployeeInfoJson> employeeInfoList =
                    mapper.readValue(new File(GlobalConstants.JSON_DATA_PATH + "editEmployeeInfo.json")
                    , new TypeReference<List<EditEmployeeInfoJson>>(){});
            Object[][] editEmployeeData = new Object[employeeInfoList.size()][9];
            for (int i = 0; i < employeeInfoList.size(); i++){
                editEmployeeData[i][0] = employeeInfoList.get(i).getEditFirstName();
                editEmployeeData[i][1] = employeeInfoList.get(i).getEditMiddleName();
                editEmployeeData[i][2] = employeeInfoList.get(i).getEditLastName();
                editEmployeeData[i][3] = employeeInfoList.get(i).getEditOtherID();
                editEmployeeData[i][4] = employeeInfoList.get(i).getEditDriverLicenseNumber();
                editEmployeeData[i][5] = employeeInfoList.get(i).getEditLicenseExpiryDate();
                editEmployeeData[i][6] = employeeInfoList.get(i).getEditNationality();
                editEmployeeData[i][7] = employeeInfoList.get(i).getEditMaritalStatus();
                editEmployeeData[i][8] = employeeInfoList.get(i).getEditDateOfBirth();
            }
            return editEmployeeData;
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }*/

}
