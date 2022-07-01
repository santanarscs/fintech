package com.santanarscs.clients.application;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santanarscs.clients.domain.Client;
import com.santanarscs.clients.infra.repositories.ClientsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {
  private final ClientsRepository repository;

  @Transactional
  public Client save(Client client){
    return repository.save(client);
  }

  public Optional<Client> getByCpf(String cpf) {
    return repository.findByCpf(cpf);
  }
}
