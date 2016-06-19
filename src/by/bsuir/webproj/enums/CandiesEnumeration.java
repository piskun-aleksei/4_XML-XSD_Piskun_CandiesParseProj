package by.bsuir.webproj.enums;

/**
 * Created by Алексей on 05.04.2016.
 */
public enum CandiesEnumeration {
    CANDIES("candies"),
    JELLYBEAN("jellybean"),
    CHOCOLATE("chocolate"),
    NAME("name"),
    TYPE("type"),
    ENERGY("energy"),
    PROTEINS("proteins"),
    FATS("fats"),
    CARBOHYDRATES("carbohydrates"),
    PRODUCTION("production"),
    SUGAR("sugar"),
    WATER("water"),
    JELLY("jelly"),
    COCOA("cocoa"),
    VALUE("value"),
    INGREDIENTS("ingredients");

    private String value;
    private CandiesEnumeration(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

}
