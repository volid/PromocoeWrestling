package com.example.valterpereira.promocoewrestling.model;

/**
 * Created by Valter Pereira on 14/02/2018.
 */

public class Promocao {
    private String name;
    private String description;
    private String  image;
    private String  website;
    private String  location;

    public Promocao(String name, String description, String image, String website, String location) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.website = website;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
