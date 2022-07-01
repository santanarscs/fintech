package com.santanarscs.clients.application;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.santanarscs.clients.application.representation.ClientSaveRequest;
import com.santanarscs.clients.domain.Client;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clients")
public class ClientsController {

  private final ClientService service;

  @GetMapping()
  public String status() {
    return "ok";
  }

  @PostMapping
  public ResponseEntity save(@RequestBody ClientSaveRequest request) {
    Client client = request.toModel();
    service.save(client);
    URI headerLocation = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .query("cpf={cpf}")
        .buildAndExpand(client.getCpf())
        .toUri();
    return ResponseEntity.created(headerLocation).build();
  }

  @GetMapping(params = "cpf")
  public ResponseEntity clientData(@RequestParam String cpf) {
    var client = service.getByCpf(cpf);
    if (client.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(client);
  }
}
