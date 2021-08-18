package net.codejava;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
//@TestMethodOrder(OrderAnnotation.class)
class ProductRepositoryTests {

	@Autowired
	ProductRepository pRepo;
	
	@Test
	@Order(1)
	public void testCreate () {
		Product p = new Product();
		p.setId(1L);
		p.setNom("iPhone XR");
		p.setPrix(100) ;
		p.setPrixAchat(50);
		pRepo.save(p);
		assertEquals("iPhone XR", p.getNom());
	}
	
	@Test
	@Order(2)
	public void testReadAll () {
		List list = pRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
		
	@Test
	@Order(3)
	public void testUpdate () {
		Product p = pRepo.findById(45L).get();
		p.setPrix(500);
		pRepo.save(p);
		assertNotEquals(800, pRepo.findById(45L).get().getPrix());
	}
		
	@Test
	@Order(4)
	public void testDelete () {
		pRepo.deleteById(46L);
		assertThat(pRepo.existsById(1L)).isFalse();
	}
	
}
