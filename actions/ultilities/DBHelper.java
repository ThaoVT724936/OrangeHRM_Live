package ultilities;

import commons.GlobalConstants;

import java.sql.*;

public class DBHelper {
    public static Connection cnn = null;

    public static Connection getConnection() {
        try {
            if (cnn == null || cnn.isClosed()) {
                cnn = DriverManager.getConnection(GlobalConstants.DB_URL, GlobalConstants.USER, GlobalConstants.PASSWORD);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cnn;
    }

}
