package ultilities;

import commons.GlobalConstants;
import org.apache.commons.lang3.RandomStringUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataHelper {

public static String randomNumber(){
    return RandomStringUtils.randomNumeric(5);
}

}
