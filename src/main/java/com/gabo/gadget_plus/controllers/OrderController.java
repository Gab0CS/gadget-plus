package com.gabo.gadget_plus.controllers;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabo.gadget_plus.dtos.OrderDTO;
import com.gabo.gadget_plus.services.OrdersCrudService;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrdersCrudService ordersCrudService;

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> read(@PathVariable Long id) {
        return ResponseEntity.ok(ordersCrudService.read(id));
    }
    
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody OrderDTO orderDTO) {
        var path = "/" + this.ordersCrudService.create(orderDTO);

        return ResponseEntity.created(URI.create(path)).build();
    }
    
}
