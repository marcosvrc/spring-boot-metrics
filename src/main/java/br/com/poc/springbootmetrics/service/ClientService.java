package br.com.poc.springbootmetrics.service;

import java.util.List;

import br.com.poc.springbootmetrics.dto.ClientDTO;

public interface ClientService {

    public ClientDTO saveClient(ClientDTO clientDTO);
    public ClientDTO findById(String id);
    public List<ClientDTO> findAll();
    public void deleteById(String id);
    
}
