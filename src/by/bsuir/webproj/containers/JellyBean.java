package by.bsuir.webproj.containers;

import javax.xml.bind.annotation.*;

/**
 * Created by Алексей on 05.04.2016.
 */
public class JellyBean extends  Candy {
    private JellyIngredients ingredients;

    public JellyBean(){
        ingredients = new JellyIngredients();
    }

    public JellyIngredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(JellyIngredients ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "JellyBean{\n    name = " + getName() + "\n  type = " + getType() + "\n  energy = " + getEnergy() +
                "\n value{\n        proteins = " + getValue().getProteins() + "\n       fats = " + getValue().getFats() +
                "\n     carbohydrates = "
                + getValue().getCarbohydrates() + "\n   }\n production = " + getProduction() + "\n  ingredients{\n      water = " +
                getIngredients().getWater() + "\n       sugar = " + getIngredients().getSugar() + "\n       jelly = "
                + getIngredients().getJelly() +
                "\n }\n}";
    }
}
