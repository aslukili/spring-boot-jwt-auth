package com.example.demo.rest;

import com.example.demo.domain.Order;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/orders")
public class CommandeResource {

    @Autowired
    OrderService orderService;


    //TODO secure the end points here
    @PostMapping("/") @ResponseBody
    @PreAuthorize("hasAuthority('RDER_WRITE')")
    public Order save(@RequestBody @Valid Order order) {
        return orderService.save(order);
    }


}
