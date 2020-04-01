package org.iesalixar.dfernandezs.proyecto.repository;

import org.iesalixar.dfernandezs.proyecto.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{

	
}
