package ru.raiffeisen.dgtl.Shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.raiffeisen.dgtl.Shop.entity.Sock;
import ru.raiffeisen.dgtl.Shop.repository.SockRepository;
import ru.raiffeisen.dgtl.Shop.util.exception.InvalidRequestException;
import ru.raiffeisen.dgtl.Shop.util.exception.OperationUnknownException;
import ru.raiffeisen.dgtl.Shop.util.exception.SockNotFoundException;

@Service
@Transactional(readOnly = true)
public class SockService {

    private final SockRepository repository;

    @Autowired
    public SockService(SockRepository repository) {
        this.repository = repository;
    }

    public Integer getAllSocks(String color, String operation, Integer cottonPart) {

        switch (operation) {
            case "moreThan" -> {
                return repository.findByColorAndCottonPartGreaterThan(color, cottonPart)
                        .stream().map(Sock::getQuantity).reduce(0, Integer::sum);
            }
            case "lessThan" -> {
                return repository.findByColorAndCottonPartLessThan(color, cottonPart)
                        .stream().map(Sock::getQuantity).reduce(0, Integer::sum);
            }
            case "equals" -> {
                return repository.findByColorAndCottonPartEquals(color, cottonPart)
                        .stream().map(Sock::getQuantity).reduce(0, Integer::sum);
            }
            default -> {
                throw new OperationUnknownException(operation);
            }
        }
    }

    @Transactional
    public void addIncome(Sock sock) {
        repository.findByColorAndCottonPart(sock.getColor(), sock.getCottonPart())
                .ifPresentOrElse(currentSock -> {
                            currentSock.setQuantity(currentSock.getQuantity() + sock.getQuantity());
                            repository.save(currentSock);
                        },
                        () -> {
                            repository.save(new Sock(sock.getColor(), sock.getCottonPart(), sock.getQuantity()));
                        });
    }

    @Transactional
    public void addOutcome(Sock sock) {
        repository.findByColorAndCottonPart(sock.getColor(), sock.getCottonPart())
                .ifPresentOrElse(currentSock -> {
                    currentSock.setQuantity(currentSock.getQuantity() - sock.getQuantity());
                    if (currentSock.getQuantity() < 0) {
                        throw new InvalidRequestException("New quantity cannot be less than zero");
                    }
                    repository.save(currentSock);
                }, () -> {
                    throw new SockNotFoundException(sock.getColor(), sock.getCottonPart());
                });
    }
}
