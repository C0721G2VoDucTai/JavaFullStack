package voductai.book_borrow_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import voductai.book_borrow_app.model.Book;
import voductai.book_borrow_app.service.IBookService;

@RestController
@RequestMapping("rest")
public class BookRestController {
    @Autowired
    IBookService bookService;
    @GetMapping("/create-book")
    public ModelAndView getPageCreateStudent() {
        return new ModelAndView("book/create-ajax");
    }
    @PostMapping("/create")
    public ResponseEntity<Book> saveStudent(@RequestBody Book book) {

        bookService.save(book);
        return new ResponseEntity<>(book,HttpStatus.CREATED);
    }


}
