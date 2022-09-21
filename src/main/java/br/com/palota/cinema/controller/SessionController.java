package br.com.palota.cinema.controller;

import br.com.palota.cinema.dto.SessionCreationRequest;
import br.com.palota.cinema.model.Session;
import br.com.palota.cinema.service.SessionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody SessionCreationRequest request) {
        sessionService.create(mapper.map(request, Session.class));
    }

    @GetMapping
    public List<Session> findAll() {
        return sessionService.findAll();
    }
}
