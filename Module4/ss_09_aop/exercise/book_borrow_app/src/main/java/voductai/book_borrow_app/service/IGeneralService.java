package voductai.book_borrow_app.service;

import voductai.book_borrow_app.model.Book;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Integer id);

    void save(T t);

    void remove(Integer id);
    public void addBorrow(T t);
}
