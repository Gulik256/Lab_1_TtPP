package ProtectionProxy;

import DAO.UsersDao;
import Impl.UsersImpl;
import Model.Users;

import java.util.List;

public class UsersProxy implements UsersDao {

    private Users users;
    private UsersDao usersDao;

    public UsersProxy(Users users) {
        this.users = users;
        this.usersDao = new UsersImpl();
    }

    @Override
    public List<Users> getAllUsers() {
        return usersDao.getAllUsers();
    }

    @Override
    public Users getByLogin(String login) {
        return usersDao.getByLogin(login);
    }

    @Override
    public Users getByUsersId(int id) {
        return usersDao.getByUsersId(id);
    }

    @Override
    public void CreateUser(Users users) {
        if (users.getId_role() == 1) {
            usersDao.CreateUser(users);
            System.out.printf("You can use the function as you are the admin\n");
        } else {
            System.out.printf("Sorry, you are not an admin!\n");
        }
    }

    @Override
    public void UpdateUser(Users users) {
        if (users.getId_role() == 1) {
            usersDao.UpdateUser(users);
            System.out.printf("You can use the function as you are the admin\n");
        } else {
            System.out.printf("Sorry, you are not an admin!\n");
        }
    }

    @Override
    public void DeleteUser(Users users) {
        if (users.getId_role() == 1) {
            usersDao.DeleteUser(users);
            System.out.printf("You can use the function as you are the admin\n");
        } else {
            System.out.printf("Sorry, you are not an admin!\n");
        }
    }

    @Override
    public void Registration() {
        usersDao.Registration();
    }

    @Override
    public Users LogIn() {
        return usersDao.LogIn();
    }
}
