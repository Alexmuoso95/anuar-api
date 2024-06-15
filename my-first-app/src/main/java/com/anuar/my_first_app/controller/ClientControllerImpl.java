package com.anuar.my_first_app.controller;

import com.anuar.my_first_app.model.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientControllerImpl {

    private List<Client> clients = new ArrayList<>();

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        for (Client client : clients) {
            if (client.getId().equals(id)) {
                return ResponseEntity.ok(client);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(clients);
    }

    @PostMapping("/create")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Long newClientId = (long) (clients.size() + 1);
        client.setId(newClientId);
        clients.add(client);
        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }



}
