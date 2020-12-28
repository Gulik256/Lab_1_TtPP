package Impl;

import DAO.UsersDao;
import Model.MatrixType;
import Model.Users;
import jdbc.ConnectionDB;

import java.net.UnknownServiceException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsersImpl implements UsersDao {
    Scanner in = new Scanner(System.in);
    @Override
    public List<Users> getAllUsers() {
        ArrayList<Users> list = new ArrayList<Users>();
        String sqlExpression = "SELECT * FROM Users";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Users users = new Users();
                users.setUsers_id(resultSet.getInt(Users.USER_ID));
                users.setLogin(resultSet.getString(Users.LOGIN));
                users.setPass(resultSet.getString(Users.PASS));
                users.setId_role(resultSet.getInt(Users.ID_ROLE));
                list.add(users);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Users getByLogin(String login) {
        Users users = null;
        String sqlExpression = "SELECT * FROM Users WHERE " + Users.LOGIN + " = ? ";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                users = new Users();
                users.setUsers_id(resultSet.getInt(Users.USER_ID));
                users.setLogin(resultSet.getString(Users.LOGIN));
                users.setPass(resultSet.getString(Users.PASS));
                users.setId_role(resultSet.getInt(Users.ID_ROLE));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public Users getByUsersId(int id) {
        Users users = null;
        String sqlExpression = "SELECT * FROM Users WHERE " + Users.USER_ID + " = ? ";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                users = new Users();
                users.setUsers_id(resultSet.getInt(Users.USER_ID));
                users.setLogin(resultSet.getString(Users.LOGIN));
                users.setPass(resultSet.getString(Users.PASS));
                users.setId_role(resultSet.getInt(Users.ID_ROLE));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void CreateUser(Users users) {
        String sqlExpression = "INSERT INTO Users (" + Users.LOGIN + Users.PASS + Users.ID_ROLE + ") VALUES (?,?,?)";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setString(1, users.getLogin());
            preparedStatement.setString(2, users.getPass());
            preparedStatement.setInt(3, users.getId_role());

            preparedStatement.execute();
            ResultSet generationKeys = preparedStatement.getGeneratedKeys();
            if (generationKeys.next()){
                int id = generationKeys.getInt(1);
                users.setUsers_id(id);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void UpdateUser(Users users) {
        String sqlExpression = "UPDATE Users SET " + Users.LOGIN + " = ? WHERE " + Users.USER_ID + " = ?";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setInt(1, users.getUsers_id());
            preparedStatement.setString(2, users.getLogin());
            preparedStatement.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void DeleteUser(Users users) {
        String sqlExpression = "DELETE FROM Users WHERE " + Users.USER_ID + " = ?";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setInt(1, users.getUsers_id());
            preparedStatement.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Registration() {
        System.out.print("Введите Логин: ");
        var Login_tmp = in.next();
        System.out.print("Введите Пароль: ");
        var Pass_tmp = in.next();

        String sqlExpression = "INSERT INTO Users (" + Users.LOGIN + Users.PASS + Users.ID_ROLE + ") " +
                               "VALUES (" + Login_tmp + "," + Pass_tmp + "," + "2"+ ")";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            System.out.println("Вы зарегистрировались");
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Users LogIn() {
        System.out.print("Введите Логин: ");
        var Login_tmp = in.next();
        System.out.print("Введите Пароль: ");
        var Pass_tmp = in.next();

        String sqlExpression = "SELECT id_role FROM Users WHERE Login = " + Login_tmp + " AND Pass = " + Pass_tmp + " LIMIT 1";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            //preparedStatement.execute();
            System.out.println("Вы вошли");
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


}
