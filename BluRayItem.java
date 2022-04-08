package com.company;

import java.io.Serializable;

public class BluRayItem implements Serializable {
    final private String name;
    final private Category category;
    private String info = null;
    final private int year;

    public BluRayItem(String name, Category category, int year) {
        this.name = name;
        this.category = category;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public String getDescription() {
        return info;
    }

    public int getYear() {return year;}
}
