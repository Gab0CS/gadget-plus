package com.gabo.gadget_plus.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.gabo.gadget_plus.dtos.OrderDTO;
import com.gabo.gadget_plus.dtos.ProductDTO;
import com.gabo.gadget_plus.entities.OrderEntity;
import com.gabo.gadget_plus.entities.ProductEntity;
import com.gabo.gadget_plus.repositories.BillRepository;
import com.gabo.gadget_plus.repositories.OrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrdersCrudServiceImpl implements  OrdersCrudService{

    private final BillRepository billRepository;

    private final OrderRepository orderRepository;

    @Override
    public String create(OrderDTO order) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
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
}
