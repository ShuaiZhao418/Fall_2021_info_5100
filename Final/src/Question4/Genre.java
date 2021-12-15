package Question4;

import java.util.ArrayList;
import java.util.List;

public class Genre {
    private String genre;
    private List<Movie> movies;
    public Genre (String genre) {
        this.genre = genre;
        this.movies = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void removeMovie(Movie movie) {
        movies.remove(movie);
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public String getGenre() {
        return genre;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
