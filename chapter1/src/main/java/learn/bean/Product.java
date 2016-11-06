package learn.bean;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 748392348L;
    private String name;
    private String description;
    private float price;

    public Product() {
        System.out.println("non featured product " + this);
    }

    public Product(String name, String description, float price) {
        this.name = name;
        this.description = description;
        this.price = price;

        System.out.println("featured product " + this);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
