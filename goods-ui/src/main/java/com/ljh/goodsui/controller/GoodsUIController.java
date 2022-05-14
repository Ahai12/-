package com.ljh.goodsui.controller;

import com.ljh.commons.pojo.Book;
import com.ljh.commons.vo.ResultVo;
import com.ljh.goodsui.service.GoodsUIService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ui")
public class GoodsUIController {

    @Resource
    private GoodsUIService goodsUIService;

    /**
     * 测试
     * @return
     */
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        goodsUIService.testGoodsProvider();
        return "success";
    }

    /**
     * 查询所有图书
     * @return
     */
    @RequestMapping("/list")
    public List<Book> getBookList(){

      List<Book> bookList =goodsUIService.getBookList();
      return bookList;
    }

    /**
     * 根据id查询图书
     * @param id
     * @return
     */
    @RequestMapping("/detail/{id}")
    public ResultVo getBookDetail(@PathVariable("id")Integer id){

        return goodsUIService.getBookDetailById(id);
    }

    @PostMapping("/add")
    public ResultVo addBook(@RequestBody Book book){
        String msg = goodsUIService.addBook(book);
        return ResultVo.ok(msg,book);
    }


}
