package org.iesalixar.dfernandezs.proyecto.service;

import org.iesalixar.dfernandezs.proyecto.model.Event;
import org.iesalixar.dfernandezs.proyecto.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EventService{
	
	@Autowired
	private EventRepository repo;

	public Event updateEvent(Event event) {
		return repo.save(event);	
	}
		
	public Event updateEventDat(Event fromEvent, Event toEvent) {
			
		toEvent.setName(fromEvent.getName());
		toEvent.setDescription(fromEvent.getDescription());
		toEvent.setPlace(fromEvent.getPlace());
		toEvent.setWebSite(fromEvent.getWebSite());
		toEvent.setStart_event(fromEvent.getStart_event());
		toEvent.setEnd_event(fromEvent.getEnd_event());

		return repo.save(toEvent);
		
	}
	
}
