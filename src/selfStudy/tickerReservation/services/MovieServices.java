package selfStudy.tickerReservation.services;

import selfStudy.tickerReservation.clases.Movie;
import selfStudy.tickerReservation.repositories.MovieRepository;

import java.util.List;
import java.util.Optional;

public class MovieServices {
    private MovieRepository movieRepository;

    public MovieServices(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public Optional<Movie> getMovieById(int id){
       return movieRepository.findByID(id);
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }
}
