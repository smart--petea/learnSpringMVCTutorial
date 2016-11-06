package learn.bean;

public class Product {
    private String name;

    public Product() {
        System.out.println("create the product " + this);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
