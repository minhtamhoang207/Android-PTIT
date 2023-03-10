package com.example.ptiit.SimpleCRUD;

public class CatModel {
    String name;
    String description;
    double price;
    int image;
    String type;

    public CatModel(){}

    public CatModel(String name, String description, double price, int image, String type) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.type = type;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CatModel{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", image=" + image +
                ", type='" + type + '\'' +
                '}';
    }
}
