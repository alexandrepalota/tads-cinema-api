package br.com.palota.cinema.repository;

import br.com.palota.cinema.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
