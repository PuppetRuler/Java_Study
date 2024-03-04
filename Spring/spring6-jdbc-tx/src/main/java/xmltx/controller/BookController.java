package xmltx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import xmltx.service.BookService;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    //买书的方法：图书id和用户id
    public void buyBook(Integer bookId,Integer userId) {
        //调用service方法
        bookService.buyBook(bookId,userId);
    }

}
