package org.iesalixar.dfernandezs.proyecto.repository;

import java.util.Set;

import org.iesalixar.dfernandezs.proyecto.model.Province;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends CrudRepository<Province, Long> {
	
	Set<Province> findAll();
	Province findById(long id);
}