package com.ljh.customersprovider.service;

import com.ljh.commons.pojo.Customer;
import com.ljh.customersprovider.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<Customer> getCustomerList() {
        return customerDao.getCustomerList();
    }

    @Override
    public void add(Customer customer) {
        customerDao.add(customer);
    }

    @Override
    public void deleteBatch(Integer[] ids) {
        customerDao.deleteBatch(ids);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerDao.getCustomerById(id);
    }

    @Override
    public void deleteCustomerById(Integer id) {
        customerDao.deleteCustomerById(id);
    }


}


