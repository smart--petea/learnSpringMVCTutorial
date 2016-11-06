package learn.bean;

import java.io.Serializable;

public class Address implements Serializable {
    private String line1;
    private String line2;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    public Address() {
        System.out.println("empty constructor " + this);
    }

    //getters and setters omitted

    public Address(String line1, String line2, String city, String state, String zipCode, String country) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        System.out.println("constructor with argumetns - " + this);
    }
}
