package by.bsuir.webproj.handlers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.Properties;

/**
 * Created by Алексей on 10.04.2016.
 */
public class RegisterUser {
    private final static Logger LOGGER = LogManager.getLogger(RegisterUser.class);
    private final static String SQL_INSERT =
            "INSERT INTO listusers(login, password) VALUES(?,?)";

    public static boolean register(String login, String password) {
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
                ps = cn.prepareStatement(SQL_INSERT);
                ps.setString(1, login);
                ps.setString(2, password);
                ps.executeUpdate();
                result = true;
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
