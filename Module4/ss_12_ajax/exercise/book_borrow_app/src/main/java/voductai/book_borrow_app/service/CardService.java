package voductai.book_borrow_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import voductai.book_borrow_app.MyException.MyException;
import voductai.book_borrow_app.model.Book;
import voductai.book_borrow_app.model.CardBorrow;
import voductai.book_borrow_app.repository.IBookRepository;
import voductai.book_borrow_app.repository.ICardBorrowRepository;

import java.util.List;
import java.util.Optional;
@Service
public class CardService implements ICardService {
    @Autowired
    ICardBorrowRepository cardBorrowRepository;
    @Autowired
    IBookRepository bookRepository;
    @Override
    public Iterable< CardBorrow > findAll() {
        return cardBorrowRepository.findAll();
    }

    @Override
    public Optional< CardBorrow > findById(Integer id) {
        return cardBorrowRepository.findById(id);
    }

    @Override
    public void save(CardBorrow cardBorrow) {
        cardBorrowRepository.save(cardBorrow);
    }

    @Override
    public void remove(Integer id) {
        cardBorrowRepository.deleteById(id);
    }

    @Override
    public void addBorrow(CardBorrow cardBorrow) {

    }

    @Override
    public Boolean returnBook(Book book, int code) throws MyException {
        List<CardBorrow> cardBorrowList = (List<CardBorrow>) cardBorrowRepository.findAll();
        if(!cardBorrowList.isEmpty()) {
            for (CardBorrow cardBorrow : cardBorrowList) {
                if (cardBorrow.getCode() == code){
                    cardBorrowRepository.deleteById(cardBorrow.getId());
                    book.setNumber(book.getNumber()+1);
                    bookRepository.save(book);
                    return true;
                }
            }
            throw new MyException();
        }
        throw new MyException();
    }
}
