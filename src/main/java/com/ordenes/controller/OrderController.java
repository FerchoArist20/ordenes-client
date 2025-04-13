package com.ordenes.controller;

import com.ordenes.model.Request;
import com.ordenes.service.OrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderClient orderClient;

    @PostMapping
    public String createOrder(@RequestBody Request request) {
        boolean success = orderClient.processRequest(request);
        return success ? "✅ Orden procesada exitosamente" : "❌ Orden rechazada";
    }
}
