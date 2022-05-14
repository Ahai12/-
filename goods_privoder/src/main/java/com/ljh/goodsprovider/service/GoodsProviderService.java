package com.ljh.goodsprovider.service;

import com.ljh.commons.pojo.Book;
import com.ljh.commons.vo.ResultVo;

import java.util.List;

public interface GoodsProviderService {

    List<Book> getBookList();

    Book getBookById(Integer id);

    ResultVo addBook(Book book);


}
