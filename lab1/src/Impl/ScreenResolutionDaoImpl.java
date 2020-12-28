package Impl;

import DAO.ScreenResolutionDao;
import Model.MatrixType;
import Model.ScreenResolution;
import jdbc.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScreenResolutionDaoImpl implements ScreenResolutionDao {

    @Override
    public List<ScreenResolution> getAllScreenResolution() {
        ArrayList<ScreenResolution> list = new ArrayList<ScreenResolution>();
        String sqlExpression = "SELECT * FROM Screen_resolution";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                ScreenResolution screenResolution = new ScreenResolution();
                screenResolution.setId(resultSet.getInt(ScreenResolution.ID));
                screenResolution.setScreenResolution(resultSet.getInt(ScreenResolution.SCREEN_RESOLUTION));
                list.add(screenResolution);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public ScreenResolution getByScreenRefreshRate(int ScreenResolution) {
        ScreenResolution screenResolution = null;
        String sqlExpression = "SELECT * FROM Screen_resolution WHERE " + Model.ScreenResolution.SCREEN_RESOLUTION + " = ? ";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setInt(1, ScreenResolution);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                screenResolution = new ScreenResolution();
                screenResolution.setId(resultSet.getInt(Model.ScreenResolution.ID));
                screenResolution.setScreenResolution(resultSet.getInt(Model.ScreenResolution.SCREEN_RESOLUTION));
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return screenResolution;
    }

    @Override
    public ScreenResolution getById(int id) {
        ScreenResolution screenResolution = null;
        String sqlExpression = "SELECT * FROM Screen_resolution WHERE " + ScreenResolution.ID + " = ? ";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                screenResolution = new ScreenResolution();
                screenResolution.setId(resultSet.getInt(ScreenResolution.ID));
                screenResolution.setScreenResolution(resultSet.getInt(ScreenResolution.SCREEN_RESOLUTION));
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return screenResolution;
    }

    @Override
    public void CreateScreenResolution(ScreenResolution screenResolution) {
        String sqlExpression = "INSERT INTO Screen_resolution (" + ScreenResolution.SCREEN_RESOLUTION + ") VALUES (?)";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setInt(1, screenResolution.getScreenResolution());
            preparedStatement.executeUpdate();
            ResultSet generationKeys = preparedStatement.getGeneratedKeys();
            if (generationKeys.next()){
                int id = generationKeys.getInt(1);
                screenResolution.setId(id);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateScreenResolution(ScreenResolution screenResolution) {
        String sqlExpression = "UPDATE Screen_resolution SET " + ScreenResolution.SCREEN_RESOLUTION + " = ? WHERE " + ScreenResolution.ID + " = ?";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setInt(1, screenResolution.getId());
            preparedStatement.setInt(2, screenResolution.getScreenResolution());
            preparedStatement.execute();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteScreenResolution(ScreenResolution screenResolution) {
        String sqlExpression = "DELETE FROM Screen_resolution WHERE " + ScreenResolution.ID + " = ?";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setInt(1, screenResolution.getId());
            preparedStatement.execute();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
