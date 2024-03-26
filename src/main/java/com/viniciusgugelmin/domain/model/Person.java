package main.java.com.viniciusgugelmin.domain.model;

abstract class Person {
    private String name;
    private Country country;

    protected Person(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    protected Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}