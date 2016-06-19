package by.bsuir.webproj.containers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigInteger;

/**
 * Created by Алексей on 05.04.2016.
 */
public class JellyIngredients{
    private int sugar;
    private int water;
    private int jelly;

    public int getSugar() {
        return sugar;
    }


    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getJelly() {
        return jelly;
    }

    public void setJelly(int carbohydrates) {
        this.jelly = carbohydrates;
    }
}
