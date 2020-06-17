package org.iesalixar.dfernandezs.proyecto.repository;

import java.util.List;

import org.iesalixar.dfernandezs.proyecto.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, Long>, JpaRepository<Event, Long> {
	
	List<Event> findAllByOrderByDateDesc();
	
    Event findByName(String name);
    
    Event deleteById(long id);
         
    List<Event> findAll();

}
