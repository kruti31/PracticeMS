package com.ms.boot.productms.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ms.boot.productms.model.DiscountRequest;
import com.ms.boot.productms.model.DiscountResponse;

@FeignClient(name = "DISCOUNTMS")
public interface DiscountServiceProxyInterface {
     
	@RequestMapping(value = "/caldisc", method = RequestMethod.POST)
    public DiscountResponse calculateDiscount(DiscountRequest request);
    
}
