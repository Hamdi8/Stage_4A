package net.codejava;
 
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.stereotype.Repository;


@RepositoryRestResource 
public interface ProductRepository extends JpaRepository<Product, Long> {

	
}