package br.com.palota.cinema.repository;

import br.com.palota.cinema.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findAllBySessionId(Long id);

}
