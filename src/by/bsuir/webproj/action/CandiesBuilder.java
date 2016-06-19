package by.bsuir.webproj.action;

import by.bsuir.webproj.containers.Candy;

import java.util.ArrayList;

/**
 * Created by Алексей on 10.04.2016.
 */
public class CandiesBuilder {
    private AbstractBuilder builder;

    public void setBuilder(AbstractBuilder builder){
        this.builder = builder;
    }

    public ArrayList<Candy> buildCandies(String fileName){
        builder.buildCandiesArray(fileName);
        return builder.getCandies();
    }
}
