package by.bsuir.webproj.handlers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.Properties;
/**
 * Created by Алексей on 10.04.2016.
 */
public class LoginChecker {
    private final static Logger LOGGER = LogManager.getLogger(LoginChecker.class);
    private final static String SQL_SELECT =
            "SELECT login, password FROM listusers WHERE login=?";

    public static boolean checkLogin(String login, String password) {
        boolean result = false;
        String url = "jdbc:mysql://localhost:3306/users";
        Properties prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "mypass");
        prop.put("autoReconnect", "true");
        prop.put("characterEncoding", "UTF-8");
        prop.put("useUnicode", "true");
        Connection cn = null;
        try {
            cn = DriverManager.getConnection(url, prop);
            PreparedStatement ps = null;
            try {
                ps = cn.prepareStatement(SQL_SELECT);
                ResultSet rs = null;
                try {
                    ps.setString(1, login);
                    rs = ps.executeQuery();
                    if(rs.next()) {
                        if(rs.getString(2).equals(password)){
                            result = true;
                        }
                    }
                } finally {
                    if (rs != null) {
                        rs.close();
                    } else {
                        LOGGER.error("ошибка во время чтения из БД");
                    }
                }
            } finally {
                if (ps != null) {
                    ps.close();
                } else {
                    LOGGER.error("Statement не создан");
                }
            }
        } catch (SQLException e) {
            LOGGER.error("DB connection error: " + e);
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    LOGGER.error("Сonnection close error: " + e);
                }
            }
        }

        return result;
    }
}
