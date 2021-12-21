package repository.impl;

import bean.User;
import repository.IUserRepository;

import javax.servlet.ServletException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/user_data_copy";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "Hunken2649";
    public static Connection connection;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List< User > selectAllUser() {
        List< User > userList = new ArrayList<>();
        try {
            Statement statement = UserRepository.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from user_infomation;");
            User user = null;
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public List< User > showAllUser() {
        List< User > userList = new ArrayList<>();
        try {
            CallableStatement callableStatement = UserRepository.connection.prepareCall("call show_all_user();");
            ResultSet resultSet = callableStatement.executeQuery();
            User user = null;
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User selectUser(int id) {
        User user = new User();
        try {
            PreparedStatement preparedStatement = UserRepository.connection.prepareStatement
                    ("select * from user_infomation  where id = ?;");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(name, email, country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void insertUser(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("insert into user_infomation(name, email, country) values(?,?,?);");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.executeLargeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addUserTran() {
        String msg = "transaction successfully";
        try {
            connection.setAutoCommit(false);
            PreparedStatement pSInsertNam = connection.prepareStatement
                    ("insert into user_infomation (name, email, country) value (?,?,?);");
            pSInsertNam.setString(1, "Nam");
            pSInsertNam.setString(2, "nam@gmail.com");
            pSInsertNam.setString(3, "Viet Nam");
            int rowEffect =pSInsertNam.executeUpdate();
            if(rowEffect == 1) {
                PreparedStatement pSInsertVu = connection.prepareStatement
                        ("insert into user_infomation (name, email, country) value (?,?,?);");
                pSInsertVu.setString(1, "Vu");
                pSInsertVu.setString(2, "vu@gmail.com");
                pSInsertVu.setString(3, "Viet Nam");
                rowEffect +=pSInsertVu.executeUpdate();
            }
            if(rowEffect ==2) {
                connection.commit();
            }else {
                msg = "rollback try";
                connection.rollback();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("update user_infomation set `name` = ?,email= ?, country =? where Id = ?;");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4, user.getId());
            preparedStatement.executeLargeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editUser(User user) {
        try {
            CallableStatement callableStatement = connection.prepareCall("call edit_user (?,?,?,?);");
            callableStatement.setString(1, user.getName());
            callableStatement.setString(2, user.getEmail());
            callableStatement.setString(3, user.getCountry());
            callableStatement.setInt(4, user.getId());
            callableStatement.executeLargeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteUser(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("delete from user_infomation where id = ?;");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropUser(int id) {
        try {
            CallableStatement callableStatement = connection.prepareCall
                    ("call delete_user (?);");
            callableStatement.setInt(1, id);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List< User > orderByName() {
        List< User > userList = new ArrayList<>();
        try {
            Statement statement = UserRepository.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * \n" +
                    "from user_infomation\n" +
                    "order by `name` asc;");
            User user = null;
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public List< User > selectByCountry(String countryName) {
        List< User > userList = new ArrayList<>();
        try {

            PreparedStatement ps = UserRepository.connection.prepareStatement("select * \n" +
                    "from user_infomation\n" +
                    "where country = ? \n" +
                    "order by `name` asc;");
            ps.setString(1, countryName);
            ResultSet resultSet = ps.executeQuery();
            User user = null;
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

}
