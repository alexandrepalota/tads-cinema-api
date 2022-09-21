package br.com.palota.cinema.dto;

import br.com.palota.cinema.model.Movie;
import br.com.palota.cinema.model.Room;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SessionCreationRequest {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "GMT-03")
    private LocalDateTime dateTime;

    private Movie movie;

    private Room room;

    private Boolean flag3d;

    private Boolean flagDubbed;

}
