package com.backend.order.mapper;

import com.backend.order.entity.DeliveryState;
import com.backend.order.entity.Good;
import com.backend.order.entity.Order;
import com.backend.order.entity.OrderItem;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    public Order mapOrderToEntity(com.backend.orderapi.Order order);
    public com.backend.orderapi.Order mapOrderToModel(Order order);

    public List<Order> mapOrderListToEntity(List<com.backend.orderapi.Order> orders);
    public List<com.backend.orderapi.Order> mapOrderListToModel(List<Order> orders);

    public OrderItem mapOrderItemToEntity(com.backend.orderapi.OrderItem orderItem);
    public com.backend.orderapi.OrderItem mapOrderItemToModel(OrderItem orderItem);

    public List<OrderItem> mapOrderItemListToEntity(List<com.backend.orderapi.OrderItem> orderItem);
    public List<com.backend.orderapi.OrderItem> mapOrderItemListToModel(List<OrderItem> orderItem);

    public Good mapGoodToEntity(com.backend.orderapi.Good good);
    public com.backend.orderapi.Good mapGoodToModel(Good good);

    public List<Good> mapGoodListToEntity(List<com.backend.orderapi.Good> good);
    public List<com.backend.orderapi.Good> mapGoodListToModel(List<Good> good);

    public DeliveryState mapDeliveryStateToEntity(com.backend.orderapi.DeliveryState state);
}
