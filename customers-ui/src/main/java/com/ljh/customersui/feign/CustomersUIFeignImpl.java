package com.ljh.customersui.feign;


import com.ljh.commons.vo.ResultVo;
import org.springframework.stereotype.Component;


@Component
public class CustomersUIFeignImpl implements CustomersUIFeign{


    @Override
    public ResultVo getCustomersList() {
        System.out.println("getCustomersList()调用失败了");
        return ResultVo.error("error,服务降级");
    }

    @Override
    public ResultVo getCustomersDetail(Integer id) {
        System.out.println("getCustomersDetail调用失败了");
        return ResultVo.error("error，feign的服务降级响应");
    }
}
