package br.com.palota.cinema.repository;

import br.com.palota.cinema.model.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Long> {

    List<Session> findAllByRoomId(Long roomId);

    List<Session> findAllByMovieId(Long roomId);

    @Query("select s from Session s where s.movie.id = :movieId and s.dateTime >= now()")
    Page<Session> findAvailableByMovieId(@Param("movieId") Long movieId, Pageable pageable);

}
