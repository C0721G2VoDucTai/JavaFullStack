package repository;

import bean.Book;
import bean.Student;
import bean.Ticket;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static utill.ConnectionSQL.close;
import static utill.ConnectionSQL.getConnection;

public class LandRepo implements ILandRepo {

    @Override
    public List< Ticket > selectAll() {
        List< Ticket > ticketList = new ArrayList<>();
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery
                    ("select b.book_id,b.book_name,b.writer, s.student_name,s.student_id, s.class, t.start_day,t.end_day, t.status, t.ticket_id\n" +
                            "from book b\n" +
                            "join ticket t on t.book_id = b.book_id\n" +
                            "join student s on s.student_id = t.student_id;");
            Book book = null;
            Student student = null;
            Ticket ticket = null;
            while (resultSet.next()) {
                student = new Student();
                ticket = new Ticket();
                book = new Book();
                student.setId(resultSet.getInt("student_id"));
                student.setName(resultSet.getString("student_name"));
                student.setGrade(resultSet.getString("class"));
                book.setId(resultSet.getString("book_id"));
                book.setName(resultSet.getString("book_id"));
                book.setWriter(resultSet.getString("writer"));
                ticket.setId(resultSet.getInt("ticket_id"));
                ticket.setStarDay(resultSet.getString("start_day"));
                ticket.setEndDay(resultSet.getString("end_day"));
                ticket.setStatus(resultSet.getString("status"));
                ticket.setBook(book);
                ticket.setStudent(student);



                ticketList.add(ticket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return ticketList;
    }

    @Override
    public Ticket selectId(String id) {
        Ticket ticket= null;
        List< Ticket > list = selectAll();
        for (Ticket temp : list) {
            if (temp.getBook().getId().equals(id)) {
                ticket = temp;
            }
        }
        return ticket;
    }
//
//    @Override
//    public void insert(Book book) {
//        try {
//            PreparedStatement preparedStatement = getConnection().prepareStatement
////                    ("insert into customer(customer_type_id,customer_name, birthday, gender,id_card,phone,email,address)" +
////                            " values(?,?,?,?,?,?,?,?)");
//        ("insert into land values(?,?,?,?,?,?,?,?);");
//            preparedStatement.setString(1, book.getId());
//            preparedStatement.setInt(2, book.getLandStatus().getId());
//            preparedStatement.setInt(3, book.getArea());
//            preparedStatement.setInt(4, book.getFloor());
//            preparedStatement.setInt(5, book.getLandType().getId());
//            preparedStatement.setInt(6, book.getPrice());
//            preparedStatement.setString(7, book.getCheckin());
//            preparedStatement.setString(8, book.getCheckout());
//            preparedStatement.executeUpdate();
//            System.out.println(book.toString());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
    @Override
    public void update(String id) {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement
                    ("update book\n" +
                            "set quantity = quantity -1\n" +
                            "where book_id = ?");
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
//
//    @Override
//    public void delete(String id) {
//        try {
//            PreparedStatement preparedStatement = getConnection().prepareStatement
//                    ("delete from land where land_id = ?;");
//            preparedStatement.setString(1, id);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public List< Book > searchThreeField(String landTypeName, int price, int floor) {
//        List< Book > bookList = new ArrayList<>();
//        try {
//            PreparedStatement ps = getConnection().prepareStatement
//                    ("select land_id,l.land_status_id,ls.land_status_name,area,floor,l.land_type_id,lt.land_type_name,\n" +
//                            "price,checkin,checkout\n" +
//                            " from land l\n" +
//                            " join land_status ls on ls.land_status_id = l.land_status_id\n" +
//                            " join land_type lt on lt.land_type_id = l.land_type_id\n" +
//                            " where (lt.land_type_name like concat('%',?,'%')) \n" +
//                            " and (price = ?) \n" +
//                            " and (floor = ?);");
//            ps.setString(1, landTypeName);
//            ps.setInt(2, price);
//            ps.setInt(3, floor);
//            ResultSet resultSet = ps.executeQuery();
//            Book book = null;
//            Student student = null;
//            Ticket ticket = null;
//            while (resultSet.next()) {
//                student = new Student();
//                ticket = new Ticket();
//                student.setId(resultSet.getInt("land_type_id"));
//                student.setName(resultSet.getString("land_type_name"));
//                ticket.setId(resultSet.getInt("land_status_id"));
//                ticket.setName(resultSet.getString("land_status_name"));
//                book = new Book();
//                book.setId(resultSet.getString("land_id"));
//                book.setLandStatus(ticket);
//                book.setArea(resultSet.getInt("area"));
//                book.setFloor(resultSet.getInt("floor"));
//                book.setLandType(student);
//                book.setPrice(resultSet.getInt("price"));
//                book.setCheckin(resultSet.getString("checkin"));
//                book.setCheckout(resultSet.getString("checkout"));
//                bookList.add(book);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return bookList;
//    }
//
//    @Override
//    public List< Book > searchOne(String landTypeName, String price, String floor) {
//        List< Book > bookList = new ArrayList<>();
//        try {
//            PreparedStatement ps = null;
//            if (landTypeName != "" && price == "" && floor == "") {
//                ps = getConnection().prepareStatement
//                        ("select land_id,l.land_status_id,ls.land_status_name,area,floor,l.land_type_id,lt.land_type_name,\n" +
//                                "price,checkin,checkout\n" +
//                                " from land l\n" +
//                                " join land_status ls on ls.land_status_id = l.land_status_id\n" +
//                                " join land_type lt on lt.land_type_id = l.land_type_id\n" +
//                                " where (lt.land_type_name like concat('%',?,'%'));");
//                ps.setString(1, landTypeName);
//            }
//            if (landTypeName == "" && price != "" && floor == "") {
//                ps = getConnection().prepareStatement
//                        ("select land_id,l.land_status_id,ls.land_status_name,area,floor,l.land_type_id,lt.land_type_name,\n" +
//                                "price,checkin,checkout\n" +
//                                " from land l\n" +
//                                " join land_status ls on ls.land_status_id = l.land_status_id\n" +
//                                " join land_type lt on lt.land_type_id = l.land_type_id\n" +
//                                " where (l.price = ?);");
//                ps.setString(1, price);
//            }
//            if (landTypeName == "" && price == "" && floor != "") {
//                ps = getConnection().prepareStatement
//                        ("select land_id,l.land_status_id,ls.land_status_name,area,floor,l.land_type_id,lt.land_type_name,\n" +
//                                "price,checkin,checkout\n" +
//                                " from land l\n" +
//                                " join land_status ls on ls.land_status_id = l.land_status_id\n" +
//                                " join land_type lt on lt.land_type_id = l.land_type_id\n" +
//                                " where (l.floor = ?);");
//                ps.setString(1, floor);
//            }
//            ResultSet resultSet = ps.executeQuery();
//            Book book = null;
//            Student student = null;
//            Ticket ticket = null;
//            while (resultSet.next()) {
//                student = new Student();
//                ticket = new Ticket();
//                student.setId(resultSet.getInt("land_type_id"));
//                student.setName(resultSet.getString("land_type_name"));
//                ticket.setId(resultSet.getInt("land_status_id"));
//                ticket.setName(resultSet.getString("land_status_name"));
//                book = new Book();
//                book.setId(resultSet.getString("land_id"));
//                book.setLandStatus(ticket);
//                book.setArea(resultSet.getInt("area"));
//                book.setFloor(resultSet.getInt("floor"));
//                book.setLandType(student);
//                book.setPrice(resultSet.getInt("price"));
//                book.setCheckin(resultSet.getString("checkin"));
//                book.setCheckout(resultSet.getString("checkout"));
//                bookList.add(book);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return bookList;
//    }
}
