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
public class GadgetPlusApplication {
	public static void main(String[] args) {
		SpringApplication.run(GadgetPlusApplication.class, args);
	}
}
