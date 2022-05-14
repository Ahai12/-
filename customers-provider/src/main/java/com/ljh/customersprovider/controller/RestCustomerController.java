package com.ljh.customersprovider.controller;

import com.ljh.commons.pojo.Customer;
import com.ljh.commons.vo.ResultVo;
import com.ljh.customersprovider.dao.CustomerDao;
import com.ljh.customersprovider.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.List;


@RestController
@RequestMapping("/provider")
public class RestCustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerDao customerDao;

    @RequestMapping("/detail")
    //paramType取值：header   query(url?id=1)  path()
    public ResultVo getCustomer(@RequestParam("id") Integer id ){
        System.out.println("休眠了3秒");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Customer customer = customerService.getCustomerById(id);
        return ResultVo.ok("success",customer);
    }

    @DeleteMapping("/{id}")
    public ResultVo deleteCustomerById(@PathVariable("id")Integer id){
        customerService.deleteCustomerById(id);
        return ResultVo.ok("success");
    }

    @PostMapping("/add")
    public ResultVo addCustomer(@RequestBody Customer customer){
        customerService.add(customer);
        return ResultVo.ok("success",customer);
    }

    @GetMapping("/list")
    public ResultVo getCustomersList(){
        List<Customer> customerList = customerService.getCustomerList();

        return ResultVo.ok("success",customerList);

    }



}
