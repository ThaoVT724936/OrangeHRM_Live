package ultilities;

import commons.GlobalConstants;

import java.sql.*;

public class DBHelper {

 /*   public static ResultSet getConnection(String query, Object paramInQuery) throws SQLException {
        ResultSet resultSet = null;
        try (
    Connection cnn = DriverManager.getConnection(GlobalConstants.DB_URL, GlobalConstants.USER, GlobalConstants.PASSWORD);
    PreparedStatement stmt = cnn.prepareStatement(query)) {
        stmt.setObject(1, paramInQuery);
        resultSet = stmt.executeQuery();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
        return resultSet;
}*/
public static Connection cnn = null;
public static PreparedStatement statement = null;

public static Connection getConnection() throws SQLException {
        try {
            cnn = DriverManager.getConnection(GlobalConstants.DB_URL, GlobalConstants.USER, GlobalConstants.PASSWORD);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return cnn;
}

}
