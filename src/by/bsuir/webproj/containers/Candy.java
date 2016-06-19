package by.bsuir.webproj.containers;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigInteger;

/**
 * Created by Алексей on 05.04.2016.
 */

public class Candy {
    private String name;
    private String type;
    private int energy;
    private Value value;
    private String production;

    public Candy(){
        value = new Value();
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public int getEnergy(){
        return energy;
    }

    public void setEnergy(int energy){
        this.energy = energy;
    }

    public Value getValue(){
        return value;
    }

    public void setValue(Value value){
        this.value = value;
    }

    public String getProduction(){
        return production;
    }

    public void setProduction(String production){
        this.production = production;
    }
}
