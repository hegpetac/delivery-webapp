package com.backend.orderapi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets delivery-state
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-02-25T15:42:07.320676200+01:00[Europe/Budapest]", comments = "Generator version: 7.10.0")
public enum DeliveryState {
  
  ACCEPTED("ACCEPTED"),
  
  PROCESSED("PROCESSED"),
  
  EN_ROUTE("EN_ROUTE"),
  
  COMPLETED("COMPLETED");

  private String value;

  DeliveryState(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static DeliveryState fromValue(String value) {
    for (DeliveryState b : DeliveryState.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

