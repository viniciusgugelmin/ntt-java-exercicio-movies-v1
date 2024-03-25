package main.java.com.viniciusgugelmin.domain.model;

abstract class Person {
    private String name;
    private Country country;

    protected Person(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected Country getCountry() {
        return country;
    }

    protected void setCountry(Country country) {
        this.country = country;
    }
}