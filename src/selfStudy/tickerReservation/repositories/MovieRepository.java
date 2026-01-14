package selfStudy.tickerReservation.repositories;

import selfStudy.tickerReservation.clases.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MovieRepository {
   private List<Movie> movieList;

    public MovieRepository() {
        this.movieList = new ArrayList<>();
    }

    public void save(Movie movie) {
        movieList.add(movie);
    }

    public List<Movie> findAll(){
        return movieList;
    }
    public Optional<Movie> findByID(int id){
      return movieList.stream().filter(movie -> movie.getId()==id)
              .findFirst();
    }

    public void deleteById(int id) {
        movieList.removeIf(movie -> movie.getId()==id);
    }
}
