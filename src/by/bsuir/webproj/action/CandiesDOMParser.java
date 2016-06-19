package by.bsuir.webproj.action;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import by.bsuir.webproj.containers.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Created by Алексей on 06.04.2016.
 */
public class CandiesDOMParser extends AbstractBuilder{
    private final static Logger LOGGER = LogManager.getLogger(CandiesDOMParser.class);
    private DocumentBuilder docBuilder;

    public CandiesDOMParser() {
        this.candies = new ArrayList<Candy>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOGGER.error("Ошибка конфигурации парсера: " + e);
        }
    }

    public ArrayList<Candy> getCandies() {
        return candies;
    }

    public void buildCandiesArray(String fileName) {
        Document doc = null;
        try {
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();

            NodeList jellyList = root.getElementsByTagName("jellybean");
            for (int i = 0; i < jellyList.getLength(); i++) {
                Element jellyElement = (Element) jellyList.item(i);
                JellyBean jelly = buildJelly(jellyElement);
                candies.add(jelly);
            }

            NodeList chocolateList = root.getElementsByTagName("chocolate");
            for (int i = 0; i < chocolateList.getLength(); i++) {
                Element chocolateElement = (Element) chocolateList.item(i);
                Chocolate choc = buildChocolate(chocolateElement);
                candies.add(choc);
            }
        } catch (IOException e) {
            LOGGER.error("File error or I/O error: " + e);
        } catch (SAXException e) {
            LOGGER.error("Parsing failure: " + e);
        }
    }

    private JellyBean buildJelly(Element candyElement) {
        JellyBean jelly = new JellyBean();

        jelly.setName(candyElement.getAttribute("name"));

        if(!candyElement.getAttribute("type").equals("")) {
            jelly.setType(candyElement.getAttribute("type"));
        }
        else {
            jelly.setType("unfilled");
        }

        Integer energy = Integer.parseInt(getElementTextContent(
                candyElement, "energy"));
        jelly.setEnergy(energy);

        Value value = jelly.getValue();
        Element valueElement = (Element) candyElement.getElementsByTagName("value").item(0);

        Integer tempValue = Integer.parseInt(getElementTextContent(valueElement, "proteins"));
        value.setProteins(tempValue);

        tempValue = Integer.parseInt(getElementTextContent(valueElement, "fats"));
        value.setFats(tempValue);

        tempValue = Integer.parseInt(getElementTextContent(valueElement, "carbohydrates"));
        value.setCarbohydrates(tempValue);

        jelly.setProduction(getElementTextContent(candyElement, "production"));

        JellyIngredients ingredients = jelly.getIngredients();
        Element ingredientsElement = (Element) candyElement.getElementsByTagName("ingredients").item(0);

        Integer tempIngredients = Integer.parseInt(getElementTextContent(ingredientsElement, "sugar"));
        ingredients.setSugar(tempIngredients);

        tempIngredients = Integer.parseInt(getElementTextContent(ingredientsElement, "water"));
        ingredients.setWater(tempIngredients);

        tempIngredients = Integer.parseInt(getElementTextContent(ingredientsElement, "jelly"));
        ingredients.setJelly(tempIngredients);

        return jelly;
    }

    private Chocolate buildChocolate(Element candyElement) {
        Chocolate chocolate = new Chocolate();

        chocolate.setName(candyElement.getAttribute("name"));

        if(!candyElement.getAttribute("type").equals("")) {
            chocolate.setType(candyElement.getAttribute("type"));
        }
        else {
            chocolate.setType("unfilled");
        }

        Integer energy = Integer.parseInt(getElementTextContent(
                candyElement, "energy"));
        chocolate.setEnergy(energy);

        Value value = chocolate.getValue();
        Element valueElement = (Element) candyElement.getElementsByTagName("value").item(0);

        Integer tempValue = Integer.parseInt(getElementTextContent(valueElement, "proteins"));
        value.setProteins(tempValue);

        tempValue = Integer.parseInt(getElementTextContent(valueElement, "fats"));
        value.setFats(tempValue);

        tempValue = Integer.parseInt(getElementTextContent(valueElement, "carbohydrates"));
        value.setCarbohydrates(tempValue);

        chocolate.setProduction(getElementTextContent(candyElement, "production"));

        ChocolateIngredients ingredients = chocolate.getIngredients();
        Element ingredientsElement = (Element) candyElement.getElementsByTagName("ingredients").item(0);

        Integer tempIngredients = Integer.parseInt(getElementTextContent(ingredientsElement, "sugar"));
        ingredients.setSugar(tempIngredients);

        tempIngredients = Integer.parseInt(getElementTextContent(ingredientsElement, "water"));
        ingredients.setWater(tempIngredients);

        tempIngredients = Integer.parseInt(getElementTextContent(ingredientsElement, "cocoa"));
        ingredients.setCocoa(tempIngredients);

        return chocolate;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}

