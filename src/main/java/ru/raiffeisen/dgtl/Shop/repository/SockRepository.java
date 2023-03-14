package ru.raiffeisen.dgtl.Shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.raiffeisen.dgtl.Shop.entity.Sock;

@Repository
public interface SockRepository extends JpaRepository<Sock, Integer> {

}
