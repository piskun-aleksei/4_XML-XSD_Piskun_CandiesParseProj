package by.bsuir.webproj.action;
import by.bsuir.webproj.containers.Candy;
import by.bsuir.webproj.handlers.CandiesSAXParserHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Алексей on 03.04.2016.
 */
public class CandiesSAXParser extends AbstractBuilder{
    private final static Logger LOGGER = LogManager.getLogger(CandiesSAXParser.class);
    private CandiesSAXParserHandler ch;
    private XMLReader reader;
    public CandiesSAXParser() {

        ch = new CandiesSAXParserHandler();
        try {

            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(ch);
        } catch (SAXException e) {
            LOGGER.error("ошибка SAX парсера: " + e);
        }
    }
    public ArrayList<Candy> getCandies() {
        return candies;
    }
    public void buildCandiesArray(String fileName) {
        try {

            reader.parse(fileName);
        } catch (SAXException e) {
            LOGGER.error("ошибка SAX парсера: " + e);
        } catch (IOException e) {
            LOGGER.error("ошибка I/О потока: " + e);
        }
        candies = ch.getCandies();
    }
}
