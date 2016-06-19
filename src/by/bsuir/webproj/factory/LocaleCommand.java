package by.bsuir.webproj.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Алексей on 10.04.2016.
 */
public class LocaleCommand implements ActionCommand {
    private final static Logger LOGGER = LogManager.getLogger(LocaleCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String rus = request.getParameter("localizeButtonMainRus");
        String eng = request.getParameter("localizeButtonMainEng");
        if(rus != null){
            request.getSession().setAttribute("locale", "ru_RU");
        }
        else {
            request.getSession().setAttribute("locale", "en_US");
        }
        String result = request.getParameter("page");
        LOGGER.debug("Locale changed");
        return result;

    }
}
