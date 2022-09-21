package br.com.palota.cinema.dto;

import br.com.palota.cinema.model.Room;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class SessionByMovieResponse {

    private Long id;

    private LocalDateTime dateTime;

    private Room room;

    private List<TicketBySessionResponse> tickets;

    private Boolean flag3d;

    private Boolean flagDubbed;

}
