package net.codejava;

import java.util.List;
import java.util.stream.Collectors;

//import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import net.codejava.Product;
import net.codejava.ProductDto;

@Component
public class ProductConverter {
	
	public ProductDto entityToDto(Product product) {
		
		ProductDto dto = new ProductDto();
		dto.setId(product.getId());
		dto.setNom(product.getNom());
		dto.setPrix(product.getPrix());
		dto.setPrixAchat(product.getPrixAchat());
		
		return dto;
		
		/*
		ModelMapper mapper =new ModelMapper();
		ProductDto map = mapper.map(product, ProductDto.class);
		return map;
		*/
	}
	public  List<ProductDto> entityToDto(List<Product> product) {
		
		return	product.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
		
	}
	
	
	public Product dtoToEntity(ProductDto dto)
	{
		
		Product st = new Product();
		st.setId(dto.getId());
		st.setNom(dto.getNom());
		st.setPrix(dto.getPrix());
		st.setPrixAchat(dto.getPrixAchat());
		
		return st;
		/*
		ModelMapper mapper = new ModelMapper();
		Product map = mapper.map(dto, Product.class);
		return map;
		*/
	}
	
	public List<Product> dtoToEntity(List<ProductDto> dto)
	{

		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}

}