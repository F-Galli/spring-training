package galli.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import galli.spring5webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
