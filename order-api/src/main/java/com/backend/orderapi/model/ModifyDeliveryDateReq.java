package com.backend.orderapi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ModifyDeliveryDateReq
 */

@JsonTypeName("modify-delivery-date-req")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-02-25T15:42:07.320676200+01:00[Europe/Budapest]", comments = "Generator version: 7.10.0")
public class ModifyDeliveryDateReq {

  private Integer orderId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate expectedDeliveryDate;

  public ModifyDeliveryDateReq orderId(Integer orderId) {
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

  public ModifyDeliveryDateReq expectedDeliveryDate(LocalDate expectedDeliveryDate) {
    this.expectedDeliveryDate = expectedDeliveryDate;
    return this;
  }

  /**
   * Get expectedDeliveryDate
   * @return expectedDeliveryDate
   */
  @Valid 
  @Schema(name = "expectedDeliveryDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("expectedDeliveryDate")
  public LocalDate getExpectedDeliveryDate() {
    return expectedDeliveryDate;
  }

  public void setExpectedDeliveryDate(LocalDate expectedDeliveryDate) {
    this.expectedDeliveryDate = expectedDeliveryDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModifyDeliveryDateReq modifyDeliveryDateReq = (ModifyDeliveryDateReq) o;
    return Objects.equals(this.orderId, modifyDeliveryDateReq.orderId) &&
        Objects.equals(this.expectedDeliveryDate, modifyDeliveryDateReq.expectedDeliveryDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, expectedDeliveryDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModifyDeliveryDateReq {\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    expectedDeliveryDate: ").append(toIndentedString(expectedDeliveryDate)).append("\n");
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

