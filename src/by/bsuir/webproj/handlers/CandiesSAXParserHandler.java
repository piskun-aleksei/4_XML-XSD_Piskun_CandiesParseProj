package by.bsuir.webproj.handlers;

import by.bsuir.webproj.containers.Candy;
import by.bsuir.webproj.containers.Chocolate;
import by.bsuir.webproj.containers.JellyBean;
import by.bsuir.webproj.enums.CandiesEnumeration;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Алексей on 03.04.2016.
 */
public class CandiesSAXParserHandler extends DefaultHandler {
    private ArrayList<Candy> candies;
    private Candy current = null;
    private CandiesEnumeration currentEnum = null;
    private EnumSet<CandiesEnumeration> withText;

    public CandiesSAXParserHandler() {
        candies = new ArrayList<Candy>();
        withText = EnumSet.range(CandiesEnumeration.NAME, CandiesEnumeration.COCOA);
    }

    public ArrayList<Candy> getCandies() {
        return candies;
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if ("jellybean".equals(localName) || "chocolate".equals(localName)) {
            if ("jellybean".equals(localName)) {
                current = new JellyBean();
            }
            else{

                current = new Chocolate();
            }
            current.setName(attrs.getValue(0));
            if (attrs.getLength() == 2) {
                current.setType(attrs.getValue(1));
            }
            else {
                current.setType("unfilled");
            }
        } else {
            CandiesEnumeration temp = CandiesEnumeration.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if ("jellybean".equals(localName) || "chocolate".equals(localName)) {
            candies.add(current);
        }
    }

    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case NAME:
                    current.setName(s);
                    break;
                case TYPE:
                    current.setType(s);
                    break;
                case ENERGY:
                    current.setEnergy(Integer.parseInt(s));
                    break;
                case PROTEINS:
                    current.getValue().setProteins(Integer.parseInt(s));
                    break;
                case FATS:
                    current.getValue().setFats(Integer.parseInt(s));
                    break;
                case CARBOHYDRATES:
                    current.getValue().setCarbohydrates(Integer.parseInt(s));
                    break;
                case PRODUCTION:
                    current.setProduction(s);
                    break;
                case SUGAR:
                    if(current.getClass().toString().equals(JellyBean.class.toString())){
                        JellyBean temp = (JellyBean) current;
                        temp.getIngredients().setSugar(Integer.parseInt(s));
                    }
                    else{
                        Chocolate temp = (Chocolate) current;
                        temp.getIngredients().setSugar(Integer.parseInt(s));
                    }
                    break;
                case WATER:
                    if(current.getClass().toString().equals(JellyBean.class.toString())){
                        JellyBean temp = (JellyBean) current;
                        temp.getIngredients().setWater(Integer.parseInt(s));
                    }
                    else{
                        Chocolate temp = (Chocolate) current;
                        temp.getIngredients().setWater(Integer.parseInt(s));
                    }
                    break;
                case JELLY:
                    JellyBean tempJel = (JellyBean) current;
                    tempJel.getIngredients().setJelly(Integer.parseInt(s));
                    break;
                case COCOA:
                    Chocolate tempChoc = (Chocolate) current;
                    tempChoc.getIngredients().setCocoa(Integer.parseInt(s));
                    break;
                default:
                    throw new EnumConstantNotPresentException(
                            currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }
}
