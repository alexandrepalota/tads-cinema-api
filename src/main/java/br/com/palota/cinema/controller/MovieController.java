package br.com.palota.cinema.controller;

import br.com.palota.cinema.dto.SessionByMovieResponse;
import br.com.palota.cinema.model.Movie;
import br.com.palota.cinema.model.Room;
import br.com.palota.cinema.model.Session;
import br.com.palota.cinema.service.MovieService;
import br.com.palota.cinema.service.RoomService;
import br.com.palota.cinema.service.SessionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Movie movie) {
        movieService.save(movie);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id, @RequestBody Movie movie) {
        movieService.update(id, movie);
    }

    @GetMapping("/{id}")
    public void findById(@PathVariable Long id) {
        movieService.findById(id);
    }

    @GetMapping
    public List<Movie> findAll() {
        return movieService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieService.delete(id);
    }

    @GetMapping("/{id}/sessions")
    public Page<SessionByMovieResponse> findSessions(@PathVariable Long id, Pageable pageable) {
        return sessionService.findAvailableByMovieId(id, pageable).map(s -> mapper.map(s, SessionByMovieResponse.class));
    }
}
