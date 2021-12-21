package voductai.book_borrow_app.model;

import javax.persistence.*;

@Entity
public class CardBorrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer code;
    @ManyToOne(targetEntity = Book.class)
    private Book book;
    @ManyToOne(targetEntity = Status.class)
    private Status status;
    public CardBorrow() {
    }

    public CardBorrow(Integer id, Integer code, Book book, Status status) {
        this.id = id;
        this.code = code;
        this.book = book;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CardBorrow{" +
                "id=" + id +
                ", code=" + code +
                ", book=" + book +
                ", status=" + status +
                '}';
    }
}
