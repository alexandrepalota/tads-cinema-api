package br.com.palota.cinema.service;

import br.com.palota.cinema.dto.TicketBuyRequest;
import br.com.palota.cinema.exception.BusinessException;
import br.com.palota.cinema.exception.NotFoundException;
import br.com.palota.cinema.model.Room;
import br.com.palota.cinema.model.Ticket;
import br.com.palota.cinema.repository.RoomRepository;
import br.com.palota.cinema.repository.SessionRepository;
import br.com.palota.cinema.repository.TicketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private ModelMapper mapper;

    public void save(TicketBuyRequest request) {
        var session = sessionService.findById(request.getSessionId());
        if (session.getDateTime().isBefore(LocalDateTime.now())) throw new BusinessException("Too late for this session");
        if (session.getRoom().getCapacity() <= session.getTickets().size()) throw new BusinessException("No more seats available");
        var ticket = mapper.map(request, Ticket.class);
        ticket.setSession(session);
        ticketRepository.save(ticket);
    }

}
