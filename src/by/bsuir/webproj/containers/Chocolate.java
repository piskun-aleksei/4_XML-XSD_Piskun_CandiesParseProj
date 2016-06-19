package by.bsuir.webproj.containers;

import javax.xml.bind.annotation.*;

/**
 * Created by Алексей on 05.04.2016.
 */
public class Chocolate extends Candy{
    private ChocolateIngredients ingredients;

    public Chocolate(){
        ingredients = new ChocolateIngredients();
    }

    public ChocolateIngredients getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Chocolate{\n    name = " + getName() + "\n  type = " + getType() + "\n  energy = " + getEnergy() +
                "\n value{\n        proteins = " + getValue().getProteins() + "\n       fats = " + getValue().getFats() +
                "\n     carbohydrates = "
                + getValue().getCarbohydrates() + "\n   }\n production = " + getProduction() + "\n  ingredients{\n      water = " +
                getIngredients().getWater() + "\n       sugar = " + getIngredients().getSugar() + "\n       cocoa = "
                + getIngredients().getCocoa() +
                "\n }\n}";
    }

    public void setIngredients(ChocolateIngredients ingredients) {
        this.ingredients = ingredients;
    }
}
