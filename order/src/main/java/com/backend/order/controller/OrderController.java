package com.backend.order.controller;

import com.backend.orderapi.OrderApi;
import com.backend.orderapi.model.*;
import com.backend.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController implements OrderApi {
    private final OrderService orderService;

    @CrossOrigin("http://localhost:4200")
    @Override
    public ResponseEntity<Good> getGoodById(Integer goodId) {
        return ResponseEntity.ok(orderService.getGoodById(goodId));
    }

    @CrossOrigin("http://localhost:4200")
    @Override
    public ResponseEntity<Order> getOrderById(Integer orderId) {
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }

    @CrossOrigin("http://localhost:4200")
    @Override
    public ResponseEntity<OrderItem> getOrderItemById(Integer orderItemId) {
        return ResponseEntity.ok(orderService.getOrderItemById(orderItemId));
    }

    @CrossOrigin("http://localhost:4200")
    @Override
    public ResponseEntity<List<Order>> getOrdersByCustomer(Integer userId) {
        return ResponseEntity.ok(orderService.getOrdersByUserId(userId));
    }

    @CrossOrigin("http://localhost:4200")
    @Override
    public ResponseEntity<List<Order>> getOrdersByDriver(Integer userId) {
        return ResponseEntity.ok(orderService.getOrdersByUserId(userId));
    }

    @CrossOrigin("http://localhost:4200")
    @Override
    public ResponseEntity<List<Order>> getOrdersByHandler(Integer userId) {
        return ResponseEntity.ok(orderService.getOrdersByUserId(userId));
    }

    @CrossOrigin("http://localhost:4200")
    @Override
    public ResponseEntity<Void> updateDeliveryState(ModifyDeliveryStateReq modifyDeliveryStateReq) {
        orderService.updateOrderDeliveryState(modifyDeliveryStateReq);
        return ResponseEntity.ok(null);
    }

    @CrossOrigin("http://localhost:4200")
    @Override
    public ResponseEntity<Void> updateDeliveryTime(ModifyDeliveryDateReq modifyDeliveryDateReq) {
        orderService.updateOrderDeliveryTime(modifyDeliveryDateReq);
        return ResponseEntity.ok(null);
    }
}
