package com.ljh.customersprovider.service;

import com.ljh.commons.pojo.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomerList();

    void add(Customer customer);

    void deleteBatch(Integer[] ids);

    Customer getCustomerById(Integer id);

    void deleteCustomerById(Integer id);
}
