package br.com.poc.springbootmetrics.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.poc.springbootmetrics.dto.ClientDTO;
import br.com.poc.springbootmetrics.entity.ClientEntity;
import br.com.poc.springbootmetrics.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ClientDTO saveClient(ClientDTO clientDTO) {
       ClientEntity clientEntity = clientRepository.save(convertDTOForEntity(clientDTO));
       return convertEntityForDTO(clientEntity);
    }

    @Override
    public ClientDTO findById(String id) {
        Optional<ClientEntity> clientEntity = clientRepository.findById(id);
        if(clientEntity.isEmpty()){
            return null;
        }
        return convertEntityForDTO(clientEntity.get());
    }

    private ClientEntity convertDTOForEntity(ClientDTO clientDTO){
        return modelMapper.map(clientDTO, ClientEntity.class);
    }

    private ClientDTO convertEntityForDTO (ClientEntity clientEntity){
        return modelMapper.map(clientEntity, ClientDTO.class);
    }

	@Override
	public List<ClientDTO> findAll() {
		  List<ClientEntity> listClientEntity = clientRepository.findAll();
		  if(listClientEntity.isEmpty()) {
			  return null;
		  }else {
			  return listClientEntity.stream().map(
					  clientEntity -> this.convertEntityForDTO(clientEntity)).collect(Collectors.toList());
		  }
	}

	@Override
	public void deleteById(String id) {
		clientRepository.deleteById(id);
	}
}
