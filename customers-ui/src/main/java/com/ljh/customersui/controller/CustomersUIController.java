package com.ljh.customersui.controller;

import com.ljh.commons.vo.ResultVo;
import com.ljh.customersui.feign.CustomersUIFeign;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/ui")
public class CustomersUIController {
    @Resource
    private CustomersUIFeign customersUIFeign;

    @GetMapping("/list")
    public ResultVo getCustomersList(){

        Object data = customersUIFeign.getCustomersList().getData();

        return ResultVo.ok("success",data);
    }

    @RequestMapping("/detail/{id}")
    public ResultVo getCustomersDetail(@PathVariable("id") Integer id){
        System.out.println("调用ui/getCustomersDetail方法");

        return customersUIFeign.getCustomersDetail(id);
    }
}
