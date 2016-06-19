package by.bsuir.webproj.action;

import by.bsuir.webproj.containers.*;
import by.bsuir.webproj.enums.CandiesEnumeration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * Created by Алексей on 06.04.2016.
 */
public class CandiesStAXParser extends AbstractBuilder {

    private final static Logger LOGGER = LogManager.getLogger(CandiesStAXParser.class);

    private XMLInputFactory inputFactory;

    public CandiesStAXParser() {
        inputFactory = XMLInputFactory.newInstance();
    }

    public ArrayList<Candy> getCandies() {
        return candies;
    }

    public void buildCandiesArray(String fileName) {
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String temp;
        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);

            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    temp = reader.getLocalName();
                    if (CandiesEnumeration.valueOf(temp.toUpperCase()) == CandiesEnumeration.JELLYBEAN) {
                        JellyBean jelly = buildJelly(reader);
                        candies.add(jelly);
                    }
                    if (CandiesEnumeration.valueOf(temp.toUpperCase()) == CandiesEnumeration.CHOCOLATE) {
                        Chocolate choc = buildChocolate(reader);
                        candies.add(choc);
                    }
                }
            }
        } catch (XMLStreamException ex) {
            LOGGER.error("StAX parsing error! " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            LOGGER.error("File " + fileName + " not found! " + ex);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                LOGGER.error("Impossible close file " + fileName + " : " + e);
            }
        }
    }

    private JellyBean buildJelly(XMLStreamReader reader) throws XMLStreamException {
        JellyBean jelly = new JellyBean();
        jelly.setName(reader.getAttributeValue(null, CandiesEnumeration.NAME.getValue()));
        String tempType = reader.getAttributeValue(null, CandiesEnumeration.TYPE.getValue());
        if(tempType != null) {
            jelly.setType(tempType);
        }
        else{
            jelly.setType("unfilled");
        }
        String temp;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    temp = reader.getLocalName();
                    switch (CandiesEnumeration.valueOf(temp.toUpperCase())) {
                        case ENERGY:
                            temp = getXMLText(reader);
                            jelly.setEnergy(Integer.parseInt(temp));
                            break;
                        case VALUE:
                            jelly.setValue(getXMLValue(reader));
                            break;
                        case PRODUCTION:
                            jelly.setProduction(getXMLText(reader));
                            break;
                        case INGREDIENTS:
                            jelly.setIngredients(getXMLJellyIngredients(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    temp = reader.getLocalName();
                    if ( CandiesEnumeration.valueOf(temp.toUpperCase()) ==  CandiesEnumeration.JELLYBEAN ){
                        return jelly;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Student");
    }

    private Chocolate buildChocolate(XMLStreamReader reader) throws XMLStreamException {
        Chocolate chocolate = new Chocolate();
        chocolate.setName(reader.getAttributeValue(null, CandiesEnumeration.NAME.getValue()));
        String tempType = reader.getAttributeValue(null, CandiesEnumeration.TYPE.getValue());
        if(tempType != null) {
            chocolate.setType(tempType);
        }
        else{
            chocolate.setType("unfilled");
        }
        String temp;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    temp = reader.getLocalName();
                    switch (CandiesEnumeration.valueOf(temp.toUpperCase())) {
                        case ENERGY:
                            temp = getXMLText(reader);
                            chocolate.setEnergy(Integer.parseInt(temp));
                            break;
                        case VALUE:
                            chocolate.setValue(getXMLValue(reader));
                            break;
                        case PRODUCTION:
                            chocolate.setProduction(getXMLText(reader));
                            break;
                        case INGREDIENTS:
                            chocolate.setIngredients(getXMLChocolateIngredients(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:

                    temp = reader.getLocalName();
                    if ( CandiesEnumeration.valueOf(temp.toUpperCase()) ==  CandiesEnumeration.CHOCOLATE ){
                        return chocolate;

                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Student");
    }

    private Value getXMLValue(XMLStreamReader reader) throws XMLStreamException {
        Value value = new Value();
        int type;
        String temp;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    temp = reader.getLocalName();
                    switch (CandiesEnumeration.valueOf(temp.toUpperCase())) {
                        case PROTEINS:
                            temp = getXMLText(reader);
                            value.setProteins(Integer.parseInt(temp));
                            break;
                        case FATS:
                            temp = getXMLText(reader);
                            value.setFats(Integer.parseInt(temp));
                            break;
                        case CARBOHYDRATES:
                            temp = getXMLText(reader);
                            value.setCarbohydrates(Integer.parseInt(temp));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    temp = reader.getLocalName();
                    if (CandiesEnumeration.valueOf(temp.toUpperCase()) == CandiesEnumeration.VALUE) {
                        return value;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Address");
    }

    private JellyIngredients getXMLJellyIngredients(XMLStreamReader reader) throws XMLStreamException {
        JellyIngredients ingredients = new JellyIngredients();
        int type;
        String temp;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    temp = reader.getLocalName();
                    switch (CandiesEnumeration.valueOf(temp.toUpperCase())) {
                        case WATER:
                            temp = getXMLText(reader);
                            ingredients.setWater(Integer.parseInt(temp));
                            break;
                        case SUGAR:
                            temp = getXMLText(reader);
                            ingredients.setSugar(Integer.parseInt(temp));
                            break;
                        case JELLY:
                            temp = getXMLText(reader);
                            ingredients.setJelly(Integer.parseInt(temp));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    temp = reader.getLocalName();
                    if (CandiesEnumeration.valueOf(temp.toUpperCase()) == CandiesEnumeration.INGREDIENTS) {
                        return ingredients;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Address");
    }

    private ChocolateIngredients getXMLChocolateIngredients(XMLStreamReader reader) throws XMLStreamException {
        ChocolateIngredients ingredients = new ChocolateIngredients();
        int type;
        String temp;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    temp = reader.getLocalName();
                    switch (CandiesEnumeration.valueOf(temp.toUpperCase())) {
                        case WATER:
                            temp = getXMLText(reader);
                            ingredients.setWater(Integer.parseInt(temp));
                            break;
                        case SUGAR:
                            temp = getXMLText(reader);
                            ingredients.setSugar(Integer.parseInt(temp));
                            break;
                        case COCOA:
                            temp = getXMLText(reader);
                            ingredients.setCocoa(Integer.parseInt(temp));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    temp = reader.getLocalName();
                    if (CandiesEnumeration.valueOf(temp.toUpperCase()) == CandiesEnumeration.INGREDIENTS) {
                        return ingredients;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Address");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
