package com.backend.orderapi.model;

import java.net.URI;
import java.util.Objects;
import com.backend.orderapi.model.DeliveryState;
import com.backend.orderapi.model.OrderItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Order
 */

@JsonTypeName("order")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-02-25T15:42:07.320676200+01:00[Europe/Budapest]", comments = "Generator version: 7.10.0")
public class Order {

  private Integer id;

  private Integer userId;

  private Integer handlerId;

  private Integer driverId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate orderPlacementDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate expectedDeliveryTime;

  private BigDecimal price;

  @Valid
  private List<@Valid OrderItem> items = new ArrayList<>();

  private DeliveryState deliveryState;

  public Order id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Order userId(Integer userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
   */
  
  @Schema(name = "userId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userId")
  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Order handlerId(Integer handlerId) {
    this.handlerId = handlerId;
    return this;
  }

  /**
   * Get handlerId
   * @return handlerId
   */
  
  @Schema(name = "handlerId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("handlerId")
  public Integer getHandlerId() {
    return handlerId;
  }

  public void setHandlerId(Integer handlerId) {
    this.handlerId = handlerId;
  }

  public Order driverId(Integer driverId) {
    this.driverId = driverId;
    return this;
  }

  /**
   * Get driverId
   * @return driverId
   */
  
  @Schema(name = "driverId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("driverId")
  public Integer getDriverId() {
    return driverId;
  }

  public void setDriverId(Integer driverId) {
    this.driverId = driverId;
  }

  public Order orderPlacementDate(LocalDate orderPlacementDate) {
    this.orderPlacementDate = orderPlacementDate;
    return this;
  }

  /**
   * Get orderPlacementDate
   * @return orderPlacementDate
   */
  @Valid 
  @Schema(name = "orderPlacementDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("orderPlacementDate")
  public LocalDate getOrderPlacementDate() {
    return orderPlacementDate;
  }

  public void setOrderPlacementDate(LocalDate orderPlacementDate) {
    this.orderPlacementDate = orderPlacementDate;
  }

  public Order expectedDeliveryTime(LocalDate expectedDeliveryTime) {
    this.expectedDeliveryTime = expectedDeliveryTime;
    return this;
  }

  /**
   * Get expectedDeliveryTime
   * @return expectedDeliveryTime
   */
  @Valid 
  @Schema(name = "expectedDeliveryTime", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("expectedDeliveryTime")
  public LocalDate getExpectedDeliveryTime() {
    return expectedDeliveryTime;
  }

  public void setExpectedDeliveryTime(LocalDate expectedDeliveryTime) {
    this.expectedDeliveryTime = expectedDeliveryTime;
  }

  public Order price(BigDecimal price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
   */
  @Valid 
  @Schema(name = "price", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("price")
  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Order items(List<@Valid OrderItem> items) {
    this.items = items;
    return this;
  }

  public Order addItemsItem(OrderItem itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Get items
   * @return items
   */
  @Valid 
  @Schema(name = "items", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("items")
  public List<@Valid OrderItem> getItems() {
    return items;
  }

  public void setItems(List<@Valid OrderItem> items) {
    this.items = items;
  }

  public Order deliveryState(DeliveryState deliveryState) {
    this.deliveryState = deliveryState;
    return this;
  }

  /**
   * Get deliveryState
   * @return deliveryState
   */
  @Valid 
  @Schema(name = "deliveryState", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("deliveryState")
  public DeliveryState getDeliveryState() {
    return deliveryState;
  }

  public void setDeliveryState(DeliveryState deliveryState) {
    this.deliveryState = deliveryState;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Order order = (Order) o;
    return Objects.equals(this.id, order.id) &&
        Objects.equals(this.userId, order.userId) &&
        Objects.equals(this.handlerId, order.handlerId) &&
        Objects.equals(this.driverId, order.driverId) &&
        Objects.equals(this.orderPlacementDate, order.orderPlacementDate) &&
        Objects.equals(this.expectedDeliveryTime, order.expectedDeliveryTime) &&
        Objects.equals(this.price, order.price) &&
        Objects.equals(this.items, order.items) &&
        Objects.equals(this.deliveryState, order.deliveryState);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userId, handlerId, driverId, orderPlacementDate, expectedDeliveryTime, price, items, deliveryState);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Order {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    handlerId: ").append(toIndentedString(handlerId)).append("\n");
    sb.append("    driverId: ").append(toIndentedString(driverId)).append("\n");
    sb.append("    orderPlacementDate: ").append(toIndentedString(orderPlacementDate)).append("\n");
    sb.append("    expectedDeliveryTime: ").append(toIndentedString(expectedDeliveryTime)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    deliveryState: ").append(toIndentedString(deliveryState)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

