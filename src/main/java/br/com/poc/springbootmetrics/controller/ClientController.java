package br.com.poc.springbootmetrics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.poc.springbootmetrics.dto.ClientDTO;
import br.com.poc.springbootmetrics.service.ClientService;
import lombok.Delegate;

@RestController
@RequestMapping("client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;	
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDTO){
		return ResponseEntity.ok(clientService.saveClient(clientDTO));
	}
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<ClientDTO> findById(@PathVariable String id){
		return ResponseEntity.ok(clientService.findById(id));
	}
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<ClientDTO>> findAllClient(){
		return ResponseEntity.ok(clientService.findAll());
	}
	
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Void> deleteById(@PathVariable String id){
		clientService.deleteById(id);
		return ResponseEntity.noContent().build();
	}


}
