package main.java.com.viniciusgugelmin.application;


import main.java.com.viniciusgugelmin.controller.MenuController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MenuController menuController = new MenuController();
        menuController.displayMenu();
    }
}
