package main.java.com.viniciusgugelmin.persistence;

import main.java.com.viniciusgugelmin.domain.model.Movie;
import main.java.com.viniciusgugelmin.util.JsonUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class MovieDatabase extends Database {

    public MovieDatabase() throws IOException {
    }

    public ArrayList<Movie> readMovies() {
        ArrayList<Movie> movies = new ArrayList<>();

        try {
            String data = readData();
            if (!data.isEmpty()) {
                movies = JsonUtil.jsonToStringArr(data, MOVIES_KEY);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return movies;
    }

    private void updateMovies(ArrayList<Movie> movies) {
        try {
            String data = JsonUtil.arrToJsonString(movies);
            writeData(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
