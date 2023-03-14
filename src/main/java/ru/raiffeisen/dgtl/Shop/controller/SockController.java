package ru.raiffeisen.dgtl.Shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.raiffeisen.dgtl.Shop.entity.Sock;
import ru.raiffeisen.dgtl.Shop.service.SockService;

import java.util.List;

@RestController(value = "/api/socks")
public class SockController {

    SockService service;

    @Autowired
    public SockController(SockService service) {
        this.service = service;
    }

    @GetMapping()
    public List<Sock> getSocks() {
        return service.getSocks();
    }

    @GetMapping(value = "/{id}")
    public Sock getSockById(@PathVariable("id") Integer id) {
        return service.getSockById(id);
    }

}
