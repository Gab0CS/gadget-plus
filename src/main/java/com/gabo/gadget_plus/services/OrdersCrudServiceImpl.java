package com.gabo.gadget_plus.services;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.gabo.gadget_plus.dtos.OrderDTO;
import com.gabo.gadget_plus.dtos.ProductDTO;
import com.gabo.gadget_plus.entities.OrderEntity;
import com.gabo.gadget_plus.entities.ProductEntity;
import com.gabo.gadget_plus.repositories.OrderRepository;
import com.gabo.gadget_plus.repositories.ProductCatalogRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrdersCrudServiceImpl implements  OrdersCrudService{

    private final OrderRepository orderRepository;
    private final ProductCatalogRepository productCatalogRepository;

    @Override
    public String create(OrderDTO order) {
        final var toInsert = this.mapOrderFromDTO(order);

        return this.orderRepository.save(toInsert).getId().toString();
        
    }

    @Override
    public OrderDTO read(Long id) {
        return this.mapOrderFromEntity(this.orderRepository.findById(id).orElseThrow());
    }

    @Override
    public OrderDTO update(OrderDTO order, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    private OrderDTO mapOrderFromEntity(OrderEntity order){
        final var modelMapper = new ModelMapper();

        modelMapper.typeMap(ProductEntity.class, ProductDTO.class)
            .addMappings(mapper -> mapper.map(
                entity -> entity.getCatalog().getName(), ProductDTO::setName
            ));

        return modelMapper.map(order, OrderDTO.class);
    }

    private OrderEntity mapOrderFromDTO(OrderDTO orderDTO){

        final var orderResponse = new OrderEntity();
        final var modelMapper = new ModelMapper();

        log.info("Before {}" ,orderResponse);
        modelMapper.map(orderDTO, orderResponse);
        log.info("After {}" ,orderResponse);

        this.getAndSetProducts(orderDTO.getProducts(), orderResponse);
        log.info("after with products {}" ,orderResponse);
        return orderResponse;
    }

    private void getAndSetProducts(List<ProductDTO> productDTOs, OrderEntity orderEntity){
        productDTOs.forEach(product -> {
            final var productFromCatalog = this.productCatalogRepository.findByName(product.getName()).orElseThrow();
            final var productEntity = ProductEntity
                .builder()
                .quantity(product.getQuantity())
                .catalog(productFromCatalog)
                .build();

            orderEntity.addProduct(productEntity);
            productEntity.setOrder(orderEntity);
        });
        
    }
}
