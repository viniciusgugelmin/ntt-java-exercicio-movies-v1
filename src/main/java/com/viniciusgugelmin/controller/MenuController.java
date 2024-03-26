package main.java.com.viniciusgugelmin.controller;

import main.java.com.viniciusgugelmin.domain.model.Country;
import main.java.com.viniciusgugelmin.domain.model.Director;
import main.java.com.viniciusgugelmin.domain.model.Movie;
import main.java.com.viniciusgugelmin.domain.model.Writer;
import main.java.com.viniciusgugelmin.persistence.MovieDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
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

    private void tryToParseProperty(Runnable callback) {
        try {
            callback.run();
        } catch (Exception e) {
            System.out.println("Invalid property. Please try again.");
            tryToParseProperty(callback);
        }
    }

    private void requestIMDb(Movie movie) {
        System.out.print("Enter the IMDb ID: ");
        tryToParseProperty(() -> movie.setImdbID(scanner.nextLine()));
    }

    private void requestTitle(Movie movie) {
        System.out.print("Enter the Title: ");
        tryToParseProperty(() -> movie.setTitle(scanner.nextLine()));
    }

    private void requestReleasedDate(Movie movie) {
        System.out.print("Enter the Released Date (yyyy-MM-dd): ");
        tryToParseProperty(() -> {
            Date released = new Date();
            released.setTime(Date.parse(scanner.nextLine()));
            movie.setReleased(released);
        });
    }

    private void addMovie() {
        System.out.println("\n=== Add Movie ===");

        Movie movie = new Movie();

        requestIMDb(movie);
        requestTitle(movie);
        requestReleasedDate(movie);


        System.out.print("Enter the Runtime: ");
        tryToParseProperty(() -> movie.setRuntime(Double.parseDouble(scanner.nextLine())));

        System.out.print("Enter the Genre: ");
        tryToParseProperty(() -> movie.setGenre(scanner.nextLine()));

        Director director = new Director();

        System.out.print("Enter the Director Name: ");
        tryToParseProperty(() -> director.setName(scanner.nextLine()));

        System.out.print("Enter the Director Country: ");
        tryToParseProperty(() -> {
            Country country = new Country(scanner.nextLine());
            director.setCountry(country);
        });

        movie.setDirector(director);

        Writer writer = new Writer();

        System.out.print("Enter the Writer Name: ");
        tryToParseProperty(() -> writer.setName(scanner.nextLine()));

        System.out.print("Enter the Writer Country: ");
        tryToParseProperty(() -> {
            Country country = new Country(scanner.nextLine());
            writer.setCountry(country);
        });

        movie.setWriter(writer);
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