package com.gabo.gadget_plus.services;

import com.gabo.gadget_plus.dtos.OrderDTO;

public interface OrdersCrudService {
    String create(OrderDTO order);
    OrderDTO read(Long id);
    OrderDTO update(OrderDTO order, Long id);
    void delete(Long id);
}
