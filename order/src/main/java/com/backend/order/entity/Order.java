package com.backend.order.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;
    private Long handlerId;
    private Long driverId;

    @Temporal(TemporalType.DATE)
    private LocalDate orderPlacementDate;

    @Temporal(TemporalType.DATE)
    private LocalDate expectedDeliveryTime;

    @Transient
    private double price;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order", fetch = FetchType.EAGER)
    private List<OrderItem> items;

    private DeliveryState deliveryState;
}
