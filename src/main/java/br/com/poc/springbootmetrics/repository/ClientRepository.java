package br.com.poc.springbootmetrics.repository;

import br.com.poc.springbootmetrics.entity.ClientEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends MongoRepository<ClientEntity, String> {

    public Optional<ClientEntity> findById(String id);


}
