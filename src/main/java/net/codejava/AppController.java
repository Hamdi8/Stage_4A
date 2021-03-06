package net.codejava; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//import com.ecommerce.microcommerce.model.Product;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
//@Service
//@Transactional
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")



public class AppController {
 
  //  @Autowired
    //private ProductRepository repo;
   /*  
    // handler methods...
    @RequestMapping("/list")
    public String viewHomePage(Model model) {
    	Product product = new Product() ;
		model.addAttribute("product", product) ;
	        return "index"  ; 
	        } 
	        */
	Logger log = LoggerFactory.getLogger(AppController.class);
	
	@Autowired ProductConverter converter;
    @Autowired
    private ProductService service; 
    
    @GetMapping("/product")
    public List<Product> getProductsList() {
    	log.debug("afficher la liste des produits ") ; 
        return service.listAll();
        
    }
	
	@GetMapping("/findAll")
	public List<ProductDto> findAll() {
		List<Product> findAll = service.listAll();
		log.debug("afficher la liste des produits ") ; 
		return converter.entityToDto(findAll);
	}
	
	@GetMapping("/find/{ID}")
	public ProductDto findById(@PathVariable(value = "ID") int id) {
		Product orElse = service.get(id);
		log.debug("afficher le produit qui a le ID : {}  ", id);
		return converter.entityToDto(orElse);
		
	}
	
	@PostMapping("/save")
	public ProductDto save(@RequestBody ProductDto dto) {
		
		Product product = converter.dtoToEntity(dto);
		service.save(product);
		log.debug(" ajouter un nouveau produit ") ;
		return converter.entityToDto(product);
	}
	
}
    
    
    
    
    
    
    
    
    /*
    @GetMapping("/product")
    public List<Product> getProductsList() {
        return service.listAll();
    }
    
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> productDetails(@PathVariable Integer id) {
        try {
            Product product = service.get(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }      
    }
   
    @PostMapping("/product")
    public void createProduct(@RequestBody Product product) {
    	
        service.save(product);
    }
    
    @PutMapping("/product/{id}")
    public ResponseEntity<?> updateProduct( @PathVariable Integer id ,@RequestBody Product product) {
        try {
            Product existProduct = service.get(id);
            service.save(product);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }      
    }
    
    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        service.delete(id);
    }
    }
    */
    