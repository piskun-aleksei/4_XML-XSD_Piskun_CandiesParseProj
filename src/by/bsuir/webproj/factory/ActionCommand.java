package by.bsuir.webproj.factory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Алексей on 10.04.2016.
 */
public interface ActionCommand {
    String execute(HttpServletRequest request);
}
