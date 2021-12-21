package voductai.book_borrow_app.service;

import voductai.book_borrow_app.MyException.MyException;
import voductai.book_borrow_app.model.Book;
import voductai.book_borrow_app.model.CardBorrow;

import java.lang.reflect.MalformedParameterizedTypeException;

public interface ICardService extends IGeneralService< CardBorrow > {
    public Boolean returnBook(Book book, int code) throws MyException;
}
