package com.es2.objects;

@SuppressWarnings("unused")
public class ResourceData {
    private final Integer id;
    private final String name;
    private final Integer year;
    private final String color;
    private final String pantone_value;

    public ResourceData(Integer id, String name, Integer year, String color, String pantone_value) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.color = color;
        this.pantone_value = pantone_value;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}