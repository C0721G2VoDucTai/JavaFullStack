package voductai.book_borrow_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import voductai.book_borrow_app.model.Book;
@Repository
public interface IBookRepository extends JpaRepository< Book,Integer > {
}
