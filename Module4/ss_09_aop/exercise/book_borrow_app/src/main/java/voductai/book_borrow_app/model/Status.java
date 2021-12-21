package voductai.book_borrow_app.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String status;
    @OneToMany(targetEntity = CardBorrow.class, mappedBy ="status")
    List<CardBorrow> cardBorrowList;

    public Status() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List< CardBorrow > getCardBorrowList() {
        return cardBorrowList;
    }

    public void setCardBorrowList(List< CardBorrow > cardBorrowList) {
        this.cardBorrowList = cardBorrowList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
