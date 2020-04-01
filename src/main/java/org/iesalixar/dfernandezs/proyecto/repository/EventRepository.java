package org.iesalixar.dfernandezs.proyecto.repository;

import org.iesalixar.dfernandezs.proyecto.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
	
	
}
