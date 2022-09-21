package br.com.palota.cinema.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_sessoes")
@Getter
@Setter
@NoArgsConstructor
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_hora")
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "sala_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "filme_id")
    private Movie movie;

    @OneToMany(mappedBy = "session")
    private List<Ticket> tickets;

    @Column(name = "flag_3d")
    private Boolean flag3d;

    @Column(name = "flag_dublado")
    private Boolean flagDubbed;

}
