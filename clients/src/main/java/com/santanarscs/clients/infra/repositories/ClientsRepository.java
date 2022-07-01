package com.santanarscs.clients.infra.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santanarscs.clients.domain.Client;

public interface ClientsRepository extends JpaRepository<Client, Long> {

  Optional<Client> findByCpf(String cpf);
  
}
