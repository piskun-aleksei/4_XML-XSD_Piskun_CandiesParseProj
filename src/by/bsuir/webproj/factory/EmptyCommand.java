package by.bsuir.webproj.factory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Алексей on 10.04.2016.
 */
public class EmptyCommand implements ActionCommand{
    private final static String ERROR_PAGE = "/jsr/error.jsp";
    @Override
    public String execute(HttpServletRequest request) {
        String page = ERROR_PAGE;
        return page;
    }
}
