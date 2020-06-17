package org.iesalixar.dfernandezs.proyecto.repository;

import java.util.List;

import org.iesalixar.dfernandezs.proyecto.model.Authority;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends CrudRepository< Authority, Long>{

	Authority findByAuthority(String authority);
	
	List<Authority> findAll();

}
