package br.com.palota.cinema.service;

import br.com.palota.cinema.exception.BusinessException;
import br.com.palota.cinema.exception.NotFoundException;
import br.com.palota.cinema.model.Room;
import br.com.palota.cinema.repository.RoomRepository;
import br.com.palota.cinema.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @Transactional
    public void save(Room room) {
        roomRepository.save(room);
    }

    @Transactional
    public void update(Long id, Room room) {
        var old = this.findById(id);
        room.setId(id);
        roomRepository.save(room);
    }

    public Room findById(Long id) {
        return roomRepository.findById(id).orElseThrow(() -> new NotFoundException(Room.class.getSimpleName() + "not found with id=" + id));
    }

    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        if (sessionRepository.findAllByRoomId(id).size() > 0) throw new BusinessException("Can't remove because there are relations");
    }
}
