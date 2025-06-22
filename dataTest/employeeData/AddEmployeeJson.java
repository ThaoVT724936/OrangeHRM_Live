package employeeData;

import commons.GlobalConstants;
import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddEmployeeJson {
    @JsonProperty("firstName")
    String firstName;

    @JsonProperty("middleName")
    String middleName;

    @JsonProperty("lastName")
    String lastName;

    public static AddEmployeeJson getAddEmployeeData(){
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new File(GlobalConstants.JSON_DATA_PATH + "addNewEmployeeData.json")
                    , AddEmployeeJson.class);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

}
