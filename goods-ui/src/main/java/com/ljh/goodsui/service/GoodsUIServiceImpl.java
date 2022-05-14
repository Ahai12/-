package com.ljh.goodsui.service;

import com.ljh.commons.pojo.Book;
import com.ljh.commons.vo.ResultVo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsUIServiceImpl implements GoodsUIService {


    @Resource
    private RestTemplate restTemplate;


    @Override
    public void testGoodsProvider() {
        String object = restTemplate.getForObject("http://goods-provider/provider/test", String.class);

        System.out.println(object);
    }

    @Override
    public List<Book> getBookList() {

        List<Book> bookList = restTemplate.getForObject("http://goods-provider/provider/list", List.class);


        return bookList;
    }

    @Override
    @HystrixCommand(
            fallbackMethod = "fallbackgetBook",commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value ="1000" )
    }
    )
    public ResultVo getBookDetailById(Integer id) {
        Book book = restTemplate.getForObject("http://goods-provider/provider/detail/" + id, Book.class);

        return ResultVo.ok("success",book);
    }

    public ResultVo fallbackgetBook(Integer id) {

        return ResultVo.error("ribbon服务降级");
    }




    @Override
    public String addBook(Book book) {
        String msg = restTemplate.postForObject("http://goods-provider/provider/add", book, String.class);

        return msg;
    }


}
