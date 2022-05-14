package com.ljh.customersprovider.dao;



import com.ljh.commons.pojo.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CustomerDao {

    List<Customer> getCustomerList();

    void add(Customer customer);

    void deleteBatch(@Param("ids") Integer[] ids);

    Customer getCustomerById(Integer id);

    void deleteCustomerById(Integer id);
}
