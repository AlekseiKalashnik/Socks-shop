package ru.raiffeisen.dgtl.Shop.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.raiffeisen.dgtl.Shop.dto.SockDto;
import ru.raiffeisen.dgtl.Shop.entity.Sock;
import ru.raiffeisen.dgtl.Shop.service.SockService;

@RestController
@RequestMapping(value = "/api/socks")
public class SockController {

    private final SockService sockService;
    private final ModelMapper modelMapper;

    @Autowired
    public SockController(SockService sockService, ModelMapper modelMapper) {
        this.sockService = sockService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public Integer getSocks(@RequestParam String color, @RequestParam String operation, @RequestParam Integer cottonPart) {
        return sockService.getAllSocks(color, operation, cottonPart);
    }

    @PostMapping("/income")
    public void income(@RequestBody SockDto sockDto) {
        sockService.addIncome(convertToSock(sockDto));
    }

    @PostMapping("/outcome")
    public void outcome(@RequestBody SockDto sockDto) {
        sockService.addOutcome(convertToSock(sockDto));
    }

    private Sock convertToSock(SockDto sockDto) {
        return modelMapper.map(sockDto, Sock.class);
    }

    private SockDto convertToSockDTO(Sock sock) {
        return modelMapper.map(sock, SockDto.class);
    }
}
