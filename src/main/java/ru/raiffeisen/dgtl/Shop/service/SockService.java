package ru.raiffeisen.dgtl.Shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.raiffeisen.dgtl.Shop.entity.Sock;
import ru.raiffeisen.dgtl.Shop.repository.SockRepository;
import ru.raiffeisen.dgtl.Shop.util.exception.SockNotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SockService {

    private final SockRepository repository;

    @Autowired
    public SockService(SockRepository repository) {
        this.repository = repository;
    }

    public List<Sock> getSocks() {
        return repository.findAll();
    }

    public Sock getSockById(Integer id) {
        Optional<Sock> sockOptional = repository.findById(id);
        return sockOptional.orElseThrow(SockNotFoundException::new);
    }

    @Transactional
    public void addNewSock(Sock sock) {

        enrichSock(sock);
        repository.save(sock);
    }

    @Transactional
    public Sock updateSock(Integer id) {
        //Sock updateSock = repository.findById(id);
        return null;
    }

    public void enrichSock(Sock sock) {
        sock.setCreatedAt(LocalDateTime.now());
        sock.setUpdatedAt(LocalDateTime.now());
    }
}
