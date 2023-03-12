package pl.phs.client;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v0.1/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientRepository clientRepository;

    @GetMapping("/")
    public ResponseEntity<List<Client>> getClients(){
        List<Client> clients = clientRepository.findAll();
        if(clients.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(clients);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Client>> getClientById(@PathVariable(value = "id") Long id){
        Optional<Client> client = clientRepository.findById(id);
        if (client.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(client);
    }
    @PostMapping("/")
    public ResponseEntity<Client> addClient(@RequestBody Client client){
        clientRepository.save(client);
        return ResponseEntity.ok(client);
    }
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable(value = "id") Long id){
        clientRepository.deleteById(id);
    }
}
