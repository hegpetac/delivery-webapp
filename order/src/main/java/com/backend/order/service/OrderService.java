package com.backend.order.service;

import com.backend.order.entity.DeliveryState;
import com.backend.order.entity.Order;
import com.backend.order.mapper.OrderMapper;

import com.backend.order.repository.GoodRepository;
import com.backend.order.repository.OrderItemRepository;
import com.backend.order.repository.OrderRepository;
import com.backend.orderapi.Good;
import com.backend.orderapi.ModifyDeliveryDateReq;
import com.backend.orderapi.ModifyDeliveryStateReq;
import com.backend.orderapi.OrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final GoodRepository goodRepository;
    private final OrderMapper orderMapper;

    public void updateOrderDeliveryState(ModifyDeliveryStateReq req) {
        Order order = orderRepository.getReferenceById(Long.valueOf(req.getOrderId()));
        DeliveryState newState = orderMapper.mapDeliveryStateToEntity(req.getDeliveryState());
        if(order.getDeliveryState().equals(newState)) {
            return;
        }
        order.setDeliveryState(newState);
        orderRepository.save(order);
    }

    public void updateOrderDeliveryTime(ModifyDeliveryDateReq req) {
        Order order = orderRepository.getReferenceById(Long.valueOf(req.getOrderId()));
        if(order.getExpectedDeliveryTime().equals(req.getExpectedDeliveryDate())) {
            return;
        }
        order.setExpectedDeliveryTime(req.getExpectedDeliveryDate());
        orderRepository.save(order);
    }

    public List<com.backend.orderapi.Order> getOrdersByUserId(Integer id) {
        List<Order> orders = orderRepository.getOrdersByUserId(Long.valueOf(id));
        orders.forEach(this::calculatePriceOfOrder);
        return orderMapper.mapOrderListToModel(orders);
    }

    public com.backend.orderapi.Order getOrderById(Integer id) {
        Order order = orderRepository.getReferenceById(Long.valueOf(id));
        calculatePriceOfOrder(order);
        return orderMapper.mapOrderToModel(order);
    }

    public OrderItem getOrderItemById(Integer id) {
        com.backend.order.entity.OrderItem orderItem = orderItemRepository.getReferenceById(Long.valueOf(id));
        calculatePriceOfOrderItem(orderItem);
        return orderMapper.mapOrderItemToModel(orderItem);
    }

    public Good getGoodById(Integer id) {
        return orderMapper.mapGoodToModel(goodRepository.getReferenceById(Long.valueOf(id)));
    }

    private void calculatePriceOfOrderItem(com.backend.order.entity.OrderItem orderItem) {
        orderItem.setPrice(orderItem.getQuantity() * orderItem.getGood().getPrice());
    }

    private void calculatePriceOfOrder(Order order) {
        double price = 0;
        for(com.backend.order.entity.OrderItem orderItem : order.getItems()) {
            calculatePriceOfOrderItem(orderItem);
            price += orderItem.getPrice();
        }
        order.setPrice(price);
    }
}
