package by.bsuir.webproj.containers;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;
import java.util.BitSet;

/**
 * Created by Алексей on 05.04.2016.
 */
public class Value {
    private int proteins;
    private int fats;
    private int carbohydrates;

    public int getProteins(){
        return proteins;
    }

    public void setProteins(int proteins){
        this.proteins = proteins;
    }

    public int getFats(){
        return fats;
    }

    public void setFats(int fats){
        this.fats = fats;
    }

    public int getCarbohydrates(){
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates){
        this.carbohydrates = carbohydrates;
    }
}
