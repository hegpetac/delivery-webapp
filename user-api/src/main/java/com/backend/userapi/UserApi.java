package com.backend.userapi;

import com.backend.userapi.api.DefaultApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "user")
public interface UserApi extends DefaultApi {
}
