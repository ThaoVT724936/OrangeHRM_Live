package employeeData;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;

import java.io.File;

public class ContactDetailsJson {
    @JsonProperty("street1")
    String street1;

    @JsonProperty("street2")
    String street2;

    @JsonProperty("city")
    String city;

    @JsonProperty("stateProvince")
    String stateProvince;

    @JsonProperty("zipPostalCode")
    String zipPostalCode;

    @JsonProperty("country")
    String country;

    @JsonProperty("home")
    String home;

    @JsonProperty("mobile")
    String mobile;

    @JsonProperty("work")
    String work;

    @JsonProperty("workEmail")
    String workEmail;

    @JsonProperty("otherEmail")
    String otherEmail;

    public static ContactDetailsJson getContactDetailsData(){
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new File(GlobalConstants.JSON_DATA_PATH + "contactDetailsData.json")
                    , ContactDetailsJson.class);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public String getStreet1() {
        return street1;
    }

    public String getStreet2() {
        return street2;
    }

    public String getCity() {
        return city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public String getZipPostalCode() {
        return zipPostalCode;
    }

    public String getCountry() {
        return country;
    }

    public String getHome() {
        return home;
    }

    public String getMobile() {
        return mobile;
    }

    public String getWork() {
        return work;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public String getOtherEmail() {
        return otherEmail;
    }



}
