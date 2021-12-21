package utill;

import bean.Book;
import bean.Student;
import bean.Ticket;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static utill.ConnectionSQL.getConnection;

public class GetData {
    public static List< Book > selectBook() {
        List< Book > bookList = new ArrayList<>();
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from book ;");
            Book book = null;
            while (resultSet.next()) {
                book = new Book();
                book.setId(resultSet.getString("book_id"));
                book.setName(resultSet.getString("book_name"));
                book.setWriter(resultSet.getString("writer"));
                book.setDescription(resultSet.getString("description"));
                book.setQuantity(resultSet.getInt("quantity"));
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }
    public static List< Student > selectStudent() {
        List< Student > studentList = new ArrayList<>();
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student ;");
            Student student = null;
            while (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt("student_id"));
                student.setName(resultSet.getString("student_name"));
                student.setGrade(resultSet.getString("class"));
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }
}
