package com.santanarscs.clients.application.representation;

import com.santanarscs.clients.domain.Client;

import lombok.Data;

@Data
public class ClientSaveRequest {
  private String name;
  private String cpf;
  private Integer age;

  public Client toModel(){
    return new Client(cpf, name, age);
  }
}
