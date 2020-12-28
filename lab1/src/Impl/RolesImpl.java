package Impl;

import DAO.RolesDao;
import Model.MatrixType;
import Model.Monitor;
import Model.Roles;
import jdbc.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RolesImpl implements RolesDao {
    @Override
    public List<Roles> getAllRoles() {
        ArrayList<Roles> list = new ArrayList<Roles>();
        String sqlExpression = "SELECT * FROM Roles";

        try(Connection connection = ConnectionDB.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Roles roles = new Roles();
                roles.setRoles_id(resultSet.getInt(Roles.ROLES_ID));
                roles.setName(resultSet.getString(Roles.NAME));
                list.add(roles);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Roles getByName(String name) {
        Roles roles = null;
        String sqlExpression = "SELECT * FROM Roles WHERE " + Roles.NAME + " = ?";
        try (Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setString(1,roles.getName());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                roles = new Roles();
                roles.setRoles_id(resultSet.getInt(Roles.ROLES_ID));
                roles.setName(resultSet.getString(Roles.NAME));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public Roles getByRolesId(int id) {
        Roles roles = null;
        String sqlExpression = "SELECT * FROM Roles WHERE " + Roles.ROLES_ID + " = ?";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                roles = new Roles();
                roles.setRoles_id(resultSet.getInt(Roles.ROLES_ID));
                roles.setName(resultSet.getString(Roles.NAME));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public void CreateRole(Roles roles) {
        String sqlExpression = "INSERT INTO Roles (" + Roles.NAME + ") values (?)";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setString(1, roles.getName());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                roles.setRoles_id(id);

            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void UpdateRole(Roles roles) {
        String sqlExpression = "UPDATE Roles SET " + Roles.NAME + " = ? WHERE " + Roles.ROLES_ID + " = ?";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setInt(1, roles.getRoles_id());
            preparedStatement.setString(2, roles.getName());
            preparedStatement.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void DeleteRole(Roles roles) {
        String sqlExpression = "DELETE FROM Roles WHERE " + Roles.ROLES_ID + " = ?";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setInt(1, roles.getRoles_id());
            preparedStatement.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
