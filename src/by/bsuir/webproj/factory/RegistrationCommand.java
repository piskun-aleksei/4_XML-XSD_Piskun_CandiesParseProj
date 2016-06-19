package by.bsuir.webproj.factory;

import by.bsuir.webproj.handlers.CryptingHashHandler;
import by.bsuir.webproj.handlers.RegisterUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Алексей on 10.04.2016.
 */
public class RegistrationCommand implements ActionCommand {
    private final static Logger LOGGER = LogManager.getLogger(RegistrationCommand.class);
    private final static String ERROR_PAGE = "/jsp/error.jsp";
    private final static String SUCCESS_PAGE = "/jsp/result.jsp";
    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        request.setAttribute("page", request.getAttribute("page"));
        String result = ERROR_PAGE;
        request.setAttribute("message", "Error while trying to register new user");
        try {
            if (RegisterUser.register(login, CryptingHashHandler.getHash(password))) {
                request.getSession().setAttribute("login", login);
                result = SUCCESS_PAGE;
                LOGGER.debug("User registered");
            }
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("No algorithm found");
        } catch (UnsupportedEncodingException e) {
            LOGGER.debug("No such encoding");
        }
        return result;

    }
}
