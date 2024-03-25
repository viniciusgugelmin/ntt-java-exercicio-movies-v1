package main.java.com.viniciusgugelmin.persistence;

import main.java.com.viniciusgugelmin.domain.model.Movie;
import main.java.com.viniciusgugelmin.util.JsonUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Database {
    private static final String FILE_PATH = "database.txt";
    private static final String MOVIES_KEY = "movies";
    private String jsonData;

    public Database() throws IOException {
        if (!fileExists()) {
            createFile();
            initializeWithMovies();
            return;
        }

        this.jsonData = readData();

        if (jsonData.isEmpty()) {
            initializeWithMovies();
        }
    }

    private boolean fileExists() {
        File file = new File(FILE_PATH);
        return file.exists();
    }

    private void createFile() {
        try {
            File file = new File(FILE_PATH);

            if (file.createNewFile()) {
                System.out.println("File created: " + FILE_PATH);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeWithMovies() throws IOException {
        jsonData = "{ \"" + MOVIES_KEY + "\": [] }";
        writeData(jsonData);
    }

    private void updateMovies(ArrayList<Movie> movies) {
        try {
            String data = JsonUtil.arrToJsonString(movies);
            writeData(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readData() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        }
    }

    public void writeData(String data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(data);
        }
    }

    public ArrayList<Movie> readMovies() {
        ArrayList<Movie> movies = new ArrayList<>();

        try {
            String data = readData();
            if (!data.isEmpty()) {
                movies = JsonUtil.jsonToStringArr(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return movies;
    }

    public void addMovie(Movie movie) {
        ArrayList<Movie> movies = readMovies();
        movies.add(movie);
        updateMovies(movies);
    }

    public void updateMovie(Movie movie) {
        ArrayList<Movie> movies = readMovies();

        for (int i = 0; i < movies.size(); i++) {
            if (Objects.equals(movies.get(i).getImdbID(), movie.getImdbID())) {
                movies.set(i, movie);
                break;
            }
        }

        updateMovies(movies);
    }

    public void removeMovie(Movie movie) {
        ArrayList<Movie> movies = readMovies();
        movies.remove(movie);
        updateMovies(movies);
    }
}
