package br.com.palota.cinema.dto;

import br.com.palota.cinema.model.Movie;
import br.com.palota.cinema.model.Room;
import br.com.palota.cinema.model.Ticket;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class SessionResponse {

    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "GMT-03")
    private LocalDateTime dateTime;

    private Room room;

    private Movie movie;

    private List<Ticket> tickets;

    private Boolean flag3d;

    private Boolean flagDubbed;
}
