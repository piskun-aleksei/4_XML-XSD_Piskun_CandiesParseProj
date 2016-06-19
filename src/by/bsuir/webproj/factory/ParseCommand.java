package by.bsuir.webproj.factory;

import by.bsuir.webproj.action.CandiesBuilder;
import by.bsuir.webproj.action.CandiesDOMParser;
import by.bsuir.webproj.action.CandiesSAXParser;
import by.bsuir.webproj.action.CandiesStAXParser;
import by.bsuir.webproj.containers.Candy;
import by.bsuir.webproj.containers.Chocolate;
import by.bsuir.webproj.containers.JellyBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by Алексей on 10.04.2016.
 */
public class ParseCommand implements ActionCommand {
    private final static Logger LOGGER = LogManager.getLogger(ParseCommand.class);
    private final static String ERROR_PAGE = "/jsp/error.jsp";
    private final static String SUCCESS_PAGE = "/jsp/tables.jsp";
    @Override
    public String execute(HttpServletRequest request) {
        String param = request.getParameter("selector");
        String result;
        request.setAttribute("message", "Parsing error");
        request.setAttribute("page", request.getAttribute("page"));
        CandiesBuilder builder = new CandiesBuilder();
        switch(param) {
            case "DOM":
                builder.setBuilder(new CandiesDOMParser());
                request.setAttribute("parserName", "DOM");
                break;
            case "SAX":
                builder.setBuilder(new CandiesSAXParser());
                request.setAttribute("parserName", "SAX");
                break;
            case "STAX":
                builder.setBuilder(new CandiesStAXParser());
                request.setAttribute("parserName", "StAX");
                break;
            default:
                result = ERROR_PAGE;
                return result;
        }
        ArrayList<Candy> candies = builder.buildCandies(request.getSession().getAttribute("xmlPath") + "/candies.xml");
        request.setAttribute("lstJelly", getJellies(candies));
        request.setAttribute("lstChoc", getChocos(candies));
        result = SUCCESS_PAGE;
        LOGGER.debug("Parse ended");
        return result;
    }

    private ArrayList<JellyBean> getJellies(ArrayList<Candy> candies){
        ArrayList<JellyBean> jellies = new ArrayList<>();
        for(int i = 0; i < candies.size(); i ++){
            if(candies.get(i).getClass().toString().equals(JellyBean.class.toString())){
                jellies.add((JellyBean)candies.get(i));
            }
        }
        return jellies;
    }

    private ArrayList<Chocolate> getChocos(ArrayList<Candy>candies ){
        ArrayList<Chocolate> chocs = new ArrayList<>();
        for(int i = 0; i < candies.size(); i ++){
            if(candies.get(i).getClass().toString().equals(Chocolate.class.toString())){
                chocs.add((Chocolate)candies.get(i));
            }
        }
        return chocs;
    }
}
