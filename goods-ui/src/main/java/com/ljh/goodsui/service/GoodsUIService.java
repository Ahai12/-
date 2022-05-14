package com.ljh.goodsui.service;

import com.ljh.commons.pojo.Book;
import com.ljh.commons.vo.ResultVo;

import java.util.List;

public interface GoodsUIService {
    void testGoodsProvider();

    List<Book> getBookList();


    ResultVo getBookDetailById(Integer id);

    String addBook(Book book);

}
