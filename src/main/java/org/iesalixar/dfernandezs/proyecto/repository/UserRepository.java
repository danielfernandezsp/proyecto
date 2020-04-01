package org.iesalixar.dfernandezs.proyecto.repository;

import org.iesalixar.dfernandezs.proyecto.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	
}
