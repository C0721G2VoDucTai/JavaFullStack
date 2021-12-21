package repository;

import bean.Book;
import bean.Ticket;

import java.util.List;

public interface ILandRepo {
    public List< Ticket > selectAll();
    public Ticket selectId(String id);
//    public void insert(Book book);
    public void update(String id) ;
//    public void delete( String id) ;
//    public List< Book > searchThreeField(String landTypeName, int price, int floor);
//    public List< Book > searchOne(String landTypeName, String price, String floor);
}
