package com.ljh.goodsprovider.service;

import com.ljh.commons.pojo.Book;
import com.ljh.commons.vo.ResultVo;
import com.ljh.goodsprovider.dao.GoodsDao;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsProviderServiceImpl implements GoodsProviderService {

    @Resource
    private GoodsDao goodsDao;


    @Override
    public List<Book> getBookList() {

        return goodsDao.getBookList();
    }

    @Override
    public Book getBookById(Integer id) {
        Book book = goodsDao.getBookById(id);
        return book;
    }

    @Override
    public ResultVo addBook(Book book) {
        goodsDao.addBook(book);
        return ResultVo.ok("success", book);
    }

}
