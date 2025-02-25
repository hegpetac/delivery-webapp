package com.backend.userapi.model;

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
 * Gets or Sets role-enum
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-02-25T15:41:28.036739700+01:00[Europe/Budapest]", comments = "Generator version: 7.10.0")
public enum RoleEnum {
  
  CUSTOMER("CUSTOMER"),
  
  DRIVER("DRIVER"),
  
  HANDLER("HANDLER");

  private String value;

  RoleEnum(String value) {
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
  public static RoleEnum fromValue(String value) {
    for (RoleEnum b : RoleEnum.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

