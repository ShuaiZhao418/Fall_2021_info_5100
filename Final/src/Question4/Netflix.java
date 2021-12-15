package Question4;

import java.util.ArrayList;
import java.util.List;

public class Netflix {

    private List<Genre> genres;

    public Netflix() {
        genres = new ArrayList<Genre>();
    }
    public void addGenre(Genre genre) {
        genres.add(genre);
    }

    public void removeGenre(Genre genre) {
        genres.remove(genre);
    }


    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}
