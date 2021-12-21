package voductai.book_borrow_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import voductai.book_borrow_app.model.CardBorrow;

@Repository
public interface ICardBorrowRepository extends JpaRepository< CardBorrow, Integer > {
}
