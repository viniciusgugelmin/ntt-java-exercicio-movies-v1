package main.java.com.viniciusgugelmin.domain.model;

import java.time.Year;
import java.util.Date;

public class Movie {
    private String imdbID;
    private String Title;
    private Year Year;
    private Date Released;
    private Double Runtime;
    private String Genre;
    /*private String Director;*/
    /*private String Writer;*/
    /*private String Actors;*/
    private String Plot;
    private Language Language;
    private Country Country;
    private String Awards;
    private String Poster;

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Date getReleased() {
        return Released;
    }

    public void setReleased(Date released) {
        Released = released;

        Year = Year.of(released.getYear() + 1900);
    }

    public Double getRuntime() {
        return Runtime;
    }

    public void setRuntime(Double runtime) {
        Runtime = runtime;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getPlot() {
        return Plot;
    }

    public void setPlot(String plot) {
        Plot = plot;
    }

    public Language getLanguage() {
        return Language;
    }

    public void setLanguage(Language language) {
        Language = language;
    }

    public Country getCountry() {
        return Country;
    }

    public void setCountry(Country country) {
        Country = country;
    }

    public String getAwards() {
        return Awards;
    }

    public void setAwards(String awards) {
        Awards = awards;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }
}
