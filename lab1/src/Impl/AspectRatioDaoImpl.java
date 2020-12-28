package Impl;

import DAO.AspectRatioDao;
import Model.AspectRatio;
import jdbc.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AspectRatioDaoImpl implements AspectRatioDao {

    @Override
    public List<AspectRatio> getAllAspectRatio() {
        ArrayList<AspectRatio> list = new ArrayList<AspectRatio>();
        String sqlExpression = "SELECT * FROM Aspect_ratio";

        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                AspectRatio aspectRatio = new AspectRatio();
                aspectRatio.setId(resultSet.getInt(AspectRatio.ID));
                aspectRatio.setAspectRatio(resultSet.getString(AspectRatio.ASPECT_RATIO));
                list.add(aspectRatio);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    @Override
    public AspectRatio getByAspectRatio(String AspectRatio) {
        AspectRatio aspectRatio = null;
        String sqlExpression = "SELECT * FROM Aspect_ratio WHERE " + Model.AspectRatio.ASPECT_RATIO + " = ?";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setString(1, Model.AspectRatio.ASPECT_RATIO);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                aspectRatio = new AspectRatio();
                aspectRatio.setId(resultSet.getInt(Model.AspectRatio.ID));
                aspectRatio.setAspectRatio(resultSet.getString(Model.AspectRatio.ASPECT_RATIO));
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return aspectRatio;
    }

    @Override
    public AspectRatio getById(int id) {
        AspectRatio aspectRatio = null;
        String sqlExpression = "SELECT * FROM Aspect_ratio WHERE " + Model.AspectRatio.ID + " = ?";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                aspectRatio = new AspectRatio();
                aspectRatio.setId(resultSet.getInt(AspectRatio.ID));
                aspectRatio.setAspectRatio(resultSet.getString(AspectRatio.ASPECT_RATIO));
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return aspectRatio;
    }

    @Override
    public void CreateAspectRatio(AspectRatio aspectRatio) {
        String sqlExpression = "INSERT INTO Aspect_ratio (" + AspectRatio.ASPECT_RATIO + ") VALUES (?)";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setString(1, AspectRatio.ASPECT_RATIO);
            preparedStatement.execute();
            ResultSet generationKeys = preparedStatement.getGeneratedKeys();
            if (generationKeys.next()){
                int id = generationKeys.getInt(1);
                aspectRatio.setId(id);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateAspectRatio(AspectRatio aspectRatio) {
        String sqlExpression = "UPDATE Aspect_ratio SET " + AspectRatio.ASPECT_RATIO + " = ? WHERE " + AspectRatio.ID + " = ?";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setInt(1, aspectRatio.getId());
            preparedStatement.setString(2, aspectRatio.getAspectRatio());
            preparedStatement.execute();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteAspectRatio(AspectRatio aspectRatio) {
        String sqlExpression = "DELETE FROM Aspect_Ratio WHERE " + AspectRatio.ID + " = ? ";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setInt(1, aspectRatio.getId());
            preparedStatement.execute();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
