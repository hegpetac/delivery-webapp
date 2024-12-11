package com.backend.orderapi;

import com.backend.orderapi.api.DefaultApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "order")
public interface OrderApi extends DefaultApi {
}