package Question4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Movie {
    private String title;
    private Date releaseDate;
    private List<String> actors;
    private String director;
    public Movie(String title, Date releaseDate, List<String> actors, String director) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.actors = actors;
        this.director = director;
    }

    // 5. Write a method which that will add release year in the title of the movie and return the title and
    //    then use this method for all the movies
    public String addDateToTitle() {
        SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy");
        String year = dayFormat.format(Date.parse(String.valueOf(this.releaseDate)));
        this.title = this.title + year;
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public List<String> getActors() {
        return actors;
    }

    public String getDirector() {
        return director;
    }
}
