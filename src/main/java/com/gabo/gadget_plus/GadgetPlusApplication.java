package com.gabo.gadget_plus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gabo.gadget_plus.entities.OrderEntity;
import com.gabo.gadget_plus.repositories.OrderRepository;

@SpringBootApplication
public class GadgetPlusApplication implements CommandLineRunner {

	@Autowired
	private OrderRepository orderRepository;

	private OrderEntity orderEntity;

	public static void main(String[] args) {
		SpringApplication.run(GadgetPlusApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.orderRepository.findAll().forEach(orderEntity -> System.out.println(orderEntity.getCreatedAt()));
	}

}
