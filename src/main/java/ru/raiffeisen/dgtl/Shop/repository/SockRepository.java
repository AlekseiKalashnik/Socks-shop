package ru.raiffeisen.dgtl.Shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.raiffeisen.dgtl.Shop.entity.Sock;

import java.util.List;
import java.util.Optional;

@Repository
public interface SockRepository extends JpaRepository<Sock, Integer> {

    Optional<Sock> findByColorAndCottonPart(String color, Integer cottonPart);
    List<Sock> findByColorAndCottonPartGreaterThan(String color, Integer cottonPart);
    List<Sock> findByColorAndCottonPartEquals(String color, Integer cottonPart);
    List<Sock> findByColorAndCottonPartLessThan(String color, Integer cottonPart);

}
