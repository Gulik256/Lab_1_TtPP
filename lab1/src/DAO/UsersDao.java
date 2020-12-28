package DAO;

import Model.Users;

import java.util.List;

public interface UsersDao {
    List<Users> getAllUsers();
    Users getByLogin(String login);
    Users getByUsersId(int id);
    void CreateUser(Users users);
    void UpdateUser(Users users);
    void DeleteUser(Users users);
    void Registration();
    Users LogIn();

//TODO create more functions;
}
