package service;

import bean.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    public List<User> selectAllUser();
    public List<User> orderByName();
    public List<User> selectByCountry(String countryName);
    public User selectUser(int id);
    public void insertUser(User user);
    public void updateUser(User user);
    public void deleteUser( int id) ;
}
