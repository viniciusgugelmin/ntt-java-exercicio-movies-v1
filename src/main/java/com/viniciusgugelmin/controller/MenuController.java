package main.java.com.viniciusgugelmin.controller;

import main.java.com.viniciusgugelmin.domain.model.Movie;
import main.java.com.viniciusgugelmin.persistence.MovieDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MenuController {
    private MovieDatabase movieDatabase;
    private Scanner scanner;

    public MenuController() throws IOException {
        this.movieDatabase = new MovieDatabase();
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\n=== Movie Database Menu ===");
            System.out.println("1. List Movies");
            System.out.println("2. Add Movie");
            System.out.println("3. Update Movie");
            System.out.println("4. Remove Movie");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    listMovies();
                    break;
                case 2:
                    addMovie();
                    break;
                case 3:
                    updateMovie();
                    break;
                case 4:
                    removeMovie();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void listMovies() {
        System.out.println("\n=== List Movies ===");
        ArrayList<Movie> movies = movieDatabase.readMovies();

        if (movies.isEmpty()) {
            System.out.println("No movies found.");
            return;
        }

        movies.forEach(System.out::println);
    }

    private void addMovie() {
        System.out.println("\n=== Add Movie ===");
    }

    private void updateMovie() {
        System.out.println("\n=== Update Movie ===");
    }

    private void removeMovie() {
        System.out.println("\n=== Remove Movie ===");
    }

    public static void main(String[] args) throws IOException {
        MenuController menuController = new MenuController();
        menuController.displayMenu();
    }
}