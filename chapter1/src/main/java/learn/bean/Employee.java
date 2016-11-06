package learn.bean;

import learn.bean.Address;

public class Employee {
    private String firstName;
    private String lastName;
    private Address homeAddress;

    public Employee() {
        System.out.println("employee no constructor arguments " + this);
    }

    public Employee(String firstName, String lastName, Address homeAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeAddress = homeAddress;
        System.out.println("employee constructor with arguments " + this);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        System.out.println(this + " setFirstName " + firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        System.out.println(this + " setLastName " + lastName);
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
        System.out.println(this + " setHomeAddress " + homeAddress);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + "\n" + homeAddress;
    }
}
