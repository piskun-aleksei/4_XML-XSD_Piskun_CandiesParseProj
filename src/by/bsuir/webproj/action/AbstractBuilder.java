package by.bsuir.webproj.action;

import by.bsuir.webproj.containers.Candy;

import java.util.ArrayList;

/**
 * Created by Алексей on 10.04.2016.
 */
public abstract class AbstractBuilder {
    protected ArrayList<Candy> candies = new ArrayList<>();

    public ArrayList<Candy> getCandies(){
        return candies;
    }
    public abstract void buildCandiesArray(String fileName);
}
