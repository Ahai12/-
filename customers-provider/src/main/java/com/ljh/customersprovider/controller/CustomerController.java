package com.ljh.customersprovider.controller;


import com.ljh.commons.pojo.Customer;
import com.ljh.commons.vo.ResultVo;
import com.ljh.customersprovider.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * 查询所有顾客
     */

    @RequestMapping("/list")
    @ResponseBody
    public List<Customer> customerList(){
        return customerService.getCustomerList();
    }

    /**
     * 添加数据
     * @param customer
     * @return
     */

    @PostMapping("/add")
    @ResponseBody
    public ResultVo add(@RequestBody Customer customer){
        customerService.add(customer);
        return ResultVo.ok("success",customer);
    }

    /**
     * 批量删除
     */

    @PostMapping("/deleteBatch")
    @ResponseBody
    public ResultVo delete(@RequestBody Integer[] ids){
        customerService.deleteBatch(ids);
        return ResultVo.ok("success");
    }
}
