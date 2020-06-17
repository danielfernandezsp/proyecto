package org.iesalixar.dfernandezs.proyecto.repository;

import java.util.List;

import org.iesalixar.dfernandezs.proyecto.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>, JpaRepository<Comment, Long> {

	
	List<Comment> findAllByOrderByDateDesc();
	
    Comment deleteById(long id);

}
