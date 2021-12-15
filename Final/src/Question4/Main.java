package Question4;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // 1. Add List of movies based on the classes created above.
        Date date1 = new GregorianCalendar(2017, Calendar.FEBRUARY, 11).getTime();
        List<String> actors1 = new ArrayList<>();
        actors1.add("abc");actors1.add("bcd");
        Movie movie1 = new Movie("aaaa", date1, actors1, "a");

        Date date2 = new GregorianCalendar(1988, Calendar.FEBRUARY, 12).getTime();
        List<String> actors2 = new ArrayList<>();
        actors2.add("cde");actors2.add("def");
        Movie movie2 = new Movie("bbbb", date2, actors2, "b");

        Date date3 = new GregorianCalendar(1999, Calendar.FEBRUARY, 10).getTime();
        List<String> actors3 = new ArrayList<>();
        actors3.add("efg");actors3.add("fgh");
        Movie movie3 = new Movie("cccc", date3, actors3, "c");

        Genre genre1 = new Genre("123");
        genre1.addMovie(movie1);
        genre1.addMovie(movie2);
        genre1.addMovie(movie3);

        Netflix netflix = new Netflix();
        netflix.addGenre(genre1);

        // 2. For all movies released before 2000, add the string "(Classic)" to the title of the movie using flatMap

        genre1.getMovies().stream().map(r -> r.getTitle() + "(Classic)").forEach(System.out::println);

        // 3. Get the latest 3 movies released using .limit() method of stream.

        genre1.getMovies().stream().limit(2);

        // 4. Create a predicate for release date before 2000 and a predicate for release date before 1990
        //    and then Chain the predicates for finding movies between 1990 and 2000.

        genre1.getMovies().stream().

        // 5. Write a method which that will add release year in the title of the movie and return the title and
        //    then use this method for all the movies.

        // addDateToTitle() method was wrote in Movie class

        for (Movie cur : genre1.getMovies()) {
            System.out.println(cur.addDateToTitle());
        }

        // 6. Sorting on one of the feature(Ex: Released year or title) which will use comparator.
        PriorityQueue<Movie> pq = new PriorityQueue<Movie>((m1, m2) -> m1.getReleaseDate().getYear() - m2.getReleaseDate().getYear());
        pq.offer(movie1);
        pq.offer(movie2);
        pq.offer(movie3);
        for (int i = 0; i < 3; i++) {
            System.out.println(pq.poll().getTitle());
        }

    }
}

