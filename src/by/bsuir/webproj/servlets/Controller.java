package by.bsuir.webproj.servlets;
import by.bsuir.webproj.factory.ActionCommand;
import by.bsuir.webproj.factory.CommandFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/controller")
public class Controller extends HttpServlet {
    private final static Logger LOGGER = LogManager.getLogger(Controller.class);
    private final static String ERROR_PAGE = "/jsp/error.jsp";
    private static String xmlPath;

    public Controller() {
        super();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        xmlPath = getServletContext().getRealPath("/xml-source");
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            LOGGER.debug("Driver set");
        } catch (SQLException e) {
            LOGGER.error("SQL exception");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().setAttribute("xmlPath", xmlPath);
        String page = null;
        CommandFactory client = new CommandFactory();
        ActionCommand command = client.defineCommand(request);
        page = command.execute(request);
        if (page != null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else {
            page = ERROR_PAGE;
            request.getSession().setAttribute("nullPage",
                 page);
            response.sendRedirect(request.getContextPath() + page);
        }
    }


}