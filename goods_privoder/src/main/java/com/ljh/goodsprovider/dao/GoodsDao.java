package com.ljh.goodsprovider.dao;


import com.ljh.commons.pojo.Book;

import java.util.List;

public interface GoodsDao {

    List<Book> getBookList();

    Book getBookById(Integer id);

    void addBook(Book book);

}
