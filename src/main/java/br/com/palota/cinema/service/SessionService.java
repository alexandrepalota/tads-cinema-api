package br.com.palota.cinema.service;

import br.com.palota.cinema.exception.BusinessException;
import br.com.palota.cinema.exception.NotFoundException;
import br.com.palota.cinema.model.Movie;
import br.com.palota.cinema.model.Session;
import br.com.palota.cinema.model.Ticket;
import br.com.palota.cinema.repository.MovieRepository;
import br.com.palota.cinema.repository.RoomRepository;
import br.com.palota.cinema.repository.SessionRepository;
import br.com.palota.cinema.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private RoomService roomService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private TicketRepository ticketRepository;

    public void create(Session session) {
        var room = roomService.findById(session.getRoom().getId());
        var movie = movieService.findById(session.getMovie().getId());
        session.setRoom(room);
        session.setMovie(movie);
        sessionRepository.save(session);
    }

    public Session findById(Long id) {
        return sessionRepository.findById(id).orElseThrow(() -> new NotFoundException(Session.class.getSimpleName() + "not found with id=" + id));
    }

    public List<Session> findAll() {
        var sessions = sessionRepository.findAll();
        return sessionRepository.findAll();
    }

    public void delete(Long id) {
        if (!ticketRepository.findAllBySessionId(id).isEmpty()) throw new BusinessException("Can't remove because there are relations");
    }

    public Page<Session> findAvailableByMovieId(Long id, Pageable pageable) {
        return sessionRepository.findAvailableByMovieId(id, pageable);
    }

}
