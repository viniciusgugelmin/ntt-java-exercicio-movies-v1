package main.java.com.viniciusgugelmin.application;


import main.java.com.viniciusgugelmin.persistence.Database;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Database database;

        try {
            database = new Database();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("Database initialized.");
    }
}
