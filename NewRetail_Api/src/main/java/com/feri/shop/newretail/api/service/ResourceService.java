package com.feri.shop.newretail.api.service;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-15 16:07
 */
@FeignClient("ResourceProvider")
public interface ResourceService {

}
