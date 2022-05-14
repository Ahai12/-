package com.ljh.goodsprovider.controller;

import com.ljh.commons.pojo.Book;
import com.ljh.goodsprovider.service.GoodsProviderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/provider")
public class GoodsProviderController {

    @Resource
    private GoodsProviderService goodsProviderService;
    /**
     * 测试goods-ui的
     * @return
     */
    @RequestMapping("/test")
    public String test(){
        System.out.println("进入了goods-provider~~~~");
        return "success";
    }

    @RequestMapping("/list")
    public List<Book> getBookList(){
      List<Book> bookList =  goodsProviderService.getBookList();
        System.out.println("进入goodsprovidercontroller");
        System.out.println(bookList);
        return bookList;
    }

    @RequestMapping("/detail/{id}")
    public Book getBookById(@PathVariable("id")Integer id){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       Book book = goodsProviderService.getBookById(id);
       return book;
    }

    @PostMapping("/add")
    public String addBook(@RequestBody Book book){
        goodsProviderService.addBook(book);
        return "success";
    }

    @HystrixCommand(fallbackMethod = "fallBack",commandProperties = {
            @HystrixProperty(name ="circuitBreaker.enabled",value = "true"), //开启
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value ="1000" ),//时间
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //次数
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50")//服务错误率

    })
    @RequestMapping("/test_hystrix")
    public String testHystrix(@RequestParam("num") Integer num){
        int n =(int)Math.floor(Math.random() * 100);
        int result = n /num;
        return "服务正常返回：" +n+"/" +num+"=" + result;
    }

    public String fallBack(@RequestParam("num") Integer num){
        return "服务降级响应：num为0";
    }

}
