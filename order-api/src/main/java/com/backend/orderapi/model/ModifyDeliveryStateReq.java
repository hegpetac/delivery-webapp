package com.backend.orderapi.model;

import java.net.URI;
import java.util.Objects;
import com.backend.orderapi.model.DeliveryState;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ModifyDeliveryStateReq
 */

@JsonTypeName("modify-delivery-state-req")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-02-25T15:42:07.320676200+01:00[Europe/Budapest]", comments = "Generator version: 7.10.0")
public class ModifyDeliveryStateReq {

  private Integer orderId;

  private DeliveryState deliveryState;

  public ModifyDeliveryStateReq orderId(Integer orderId) {
    this.orderId = orderId;
    return this;
  }

  /**
   * Get orderId
   * @return orderId
   */
  
  @Schema(name = "orderId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("orderId")
  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public ModifyDeliveryStateReq deliveryState(DeliveryState deliveryState) {
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
    ModifyDeliveryStateReq modifyDeliveryStateReq = (ModifyDeliveryStateReq) o;
    return Objects.equals(this.orderId, modifyDeliveryStateReq.orderId) &&
        Objects.equals(this.deliveryState, modifyDeliveryStateReq.deliveryState);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, deliveryState);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModifyDeliveryStateReq {\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
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

