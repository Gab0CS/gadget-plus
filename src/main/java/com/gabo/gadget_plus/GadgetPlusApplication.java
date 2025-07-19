package com.gabo.gadget_plus;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gabo.gadget_plus.entities.BillEntity;
import com.gabo.gadget_plus.entities.OrderEntity;
import com.gabo.gadget_plus.entities.ProductEntity;
import com.gabo.gadget_plus.repositories.BillRepository;
import com.gabo.gadget_plus.repositories.CategoryRepository;
import com.gabo.gadget_plus.repositories.OrderRepository;
import com.gabo.gadget_plus.repositories.ProductCatalogRepository;
import com.gabo.gadget_plus.repositories.ProductRepository;
import com.gabo.gadget_plus.repositories.RejectProductRepository;

import lombok.val;

@SpringBootApplication
public class GadgetPlusApplication implements CommandLineRunner {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired	
	private BillRepository billRepository;

	@Autowired	
	private ProductCatalogRepository productCatalogRepository;
	@Autowired	
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private RejectProductRepository rejectProductRepository;

	public static void main(String[] args) {
		SpringApplication.run(GadgetPlusApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		// final var home = this.categoryRepository.findById(1L).orElseThrow();
		// final var office = this.categoryRepository.findById(2L).orElseThrow();

		// this.productCatalogRepository.findAll().forEach(product -> {
		// 	if (product.getDescription().contains("home")) {
		// 		product.addCategory(home);
		// 	}
		// 	if (product.getDescription().contains("office")) {
		// 		product.addCategory(office);
		// 	}

		// 	this.productCatalogRepository.save(product);
		// });



		// var random = new Random();

		// var productCatalog = new LinkedList<>(this.productCatalogRepository.findAll()); 

		// IntStream.range(0, productCatalog.size()).forEach(i -> {
		// 	var idOrderRandom = random.nextLong(16) + 1;
		// 	var orderRandom = this.orderRepository.findById(idOrderRandom).orElseThrow();

		// 	var product = ProductEntity.builder()
		// 		.quantity(BigInteger.valueOf(random.nextInt(5) + 1))
		// 		.catalog(productCatalog.poll())
		// 		.build();

		// 	orderRandom.addProduct(product);
		// 	product.setOrder(orderRandom);

		// 	this.orderRepository.save(orderRandom);
		// });

		this.rejectProductRepository.findAll().forEach(System.out::println);
	}

}
