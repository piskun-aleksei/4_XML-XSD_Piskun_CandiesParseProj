package by.bsuir.webproj.factory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Алексей on 10.04.2016.
 */
public class BackCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return request.getParameter("backPage");
    }
}
