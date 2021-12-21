package voductai.book_borrow_app.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import voductai.book_borrow_app.MyException.MyException;
import voductai.book_borrow_app.model.Book;
import voductai.book_borrow_app.model.CardBorrow;
import voductai.book_borrow_app.model.Status;
import voductai.book_borrow_app.service.IBookService;
import voductai.book_borrow_app.service.ICardService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Controller
public class BookController {
    @Autowired
    IBookService bookService;
    @Autowired
    ICardService cardService;

    @GetMapping("/")
    public String showHome(Model model) {
        return "/book/home";
    }

    @GetMapping("/book")
    public String showListBook(Model model) {
        model.addAttribute("bookList", bookService.findAll());
        return "/book/list";
    }

    @GetMapping("/create-book")
    public String showCreateForm(Model model) {
        model.addAttribute("book", new Book());
        return "/book/create";
    }

    @PostMapping("/create-book")
    public String saveBook(@Valid @ModelAttribute("book") Book book, Model model) {
        bookService.save(book);
        model.addAttribute("book", book);
        model.addAttribute("message", "New book created successfully");
        return "redirect:book";
    }

    @GetMapping("/borrow-book/{id}")
    public String showFormBorrow(@PathVariable Integer id, Model model) {
        Optional< Book > book = bookService.findById(id);
        if (book.get().getNumber() != 0) {
            model.addAttribute("book", book.get());
            return "/book/detail";

        } else {
            return "/error.404";
        }
    }

    @PostMapping("/borrow/borrowBook/{id}")
    public String borrowBook(@PathVariable Integer id, Model model,
                             RedirectAttributes redirectAttributes) {
        Optional< Book > bookOptional = bookService.findById(id);
        Book book = bookOptional.get();
        book.setNumber(book.getNumber() - 1);
        bookService.save(book);
        bookService.addBorrow(book);
        model.addAttribute("bookList", bookService.findAll());
//        redirectAttributes.addFlashAttribute("message", "Borrow successfully");
        return "/book/list2";
    }

    @GetMapping("/return-book/{id}")
    public String showFormReturn(@PathVariable Integer id, Model model) {
        Optional< Book > book = bookService.findById(id);
        if (book != null) {
            model.addAttribute("book", book.get());
            return "/book/return";
        } else {
            return "/error.404";
        }
    }

    @PostMapping("/return")
    public String returnBook(@ModelAttribute("book") Book book,
                             @RequestParam String code,
                             Model model,
                             RedirectAttributes redirectAttributes) throws MyException{
        if (cardService.returnBook(book, Integer.parseInt(code))) {
            redirectAttributes.addFlashAttribute("message", "Return successfully");
            return "redirect:book";
        }else {
            throw new MyException();
//            redirectAttributes.addFlashAttribute("message", "Not found your book borrow");
//            return "redirect:book";
        }
    }

    @GetMapping("/borrow-list")
    public String showListBorrow(Model model) {
        model.addAttribute("cardBorrowList", cardService.findAll());
        return "/borrow/list";
    }
    @ExceptionHandler(MyException.class)
    public String handleException(Model model){
        return "/error.404";
    }
    @ExceptionHandler(NumberFormatException.class)
    public String handleNumberFormatException(Model model){
        return "/error.404";
    }
}

