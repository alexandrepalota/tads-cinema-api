package br.com.palota.cinema.service;

import br.com.palota.cinema.exception.BusinessException;
import br.com.palota.cinema.exception.NotFoundException;
import br.com.palota.cinema.model.Movie;
import br.com.palota.cinema.model.Room;
import br.com.palota.cinema.repository.MovieRepository;
import br.com.palota.cinema.repository.RoomRepository;
import br.com.palota.cinema.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private SessionRepository sessionRepository;

    public void save(Movie room) {
        movieRepository.save(room);
    }

    public void update(Long id, Movie movie) {
        this.findById(id);
        movie.setId(id);
        movieRepository.save(movie);
    }

    public Movie findById(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new NotFoundException(Movie.class.getSimpleName() + "not found with id=" + id));
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public void delete(Long id) {
        if (sessionRepository.findAllByMovieId(id).size() > 0) throw new BusinessException("Can't remove because there are relations");
    }

}
