package com.ljh.customersui.feign;

import com.ljh.commons.vo.ResultVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "customers-provider",fallback = CustomersUIFeignImpl.class)
public interface CustomersUIFeign {


    @GetMapping("/provider/list")
    ResultVo getCustomersList();


    @GetMapping("/provider/detail")
    ResultVo getCustomersDetail(@RequestParam("id") Integer id);

}
