package commons;

public class GlobalConstants {
    //System Infor
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String SEPARATOR = System.getProperty("file.separator");
    public static final String OS_NAME = System.getProperty("os.name");

    //Login info
    public static final String PAGE_URL = "http://localhost/orangehrm/web/index.php/auth/login";
    public static final String userName = "orange_hrm";
    public static final String password = "Orange@123456789";

    //wait time
    public static final long LONG_TIME = 30;
    public static final short SHORT_TIME = 10;

    //upload/download file path
    public static final String UPLOAD_FILE = PROJECT_PATH + SEPARATOR + "uploadFiles"+SEPARATOR;

    //json data path
    public static final String JSON_DATA_PATH = PROJECT_PATH + SEPARATOR + "resources" + SEPARATOR;

    //DB connection
    public static final String DB_URL = "jdbc:mysql://localhost:3306/orange_hrm?useSSL=false&serverTimezone=UTC";
    public static final String USER = "root";
    public static final String PASSWORD = "";

    //success message
    public static final String SAVE_SUCCESS = "Successfully Saved";
    public static final String UPDATE_SUCCESS = "Successfully Updated";



}
