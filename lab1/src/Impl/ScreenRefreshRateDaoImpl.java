package Impl;

import DAO.ScreenRefreshRateDao;
import Model.MatrixType;
import Model.ScreenRefreshRate;
import jdbc.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScreenRefreshRateDaoImpl implements ScreenRefreshRateDao {

    @Override
    public List<ScreenRefreshRate> getAllScreenRefreshRate() {
        ArrayList<ScreenRefreshRate> list = new ArrayList<ScreenRefreshRate>();
        String sqlExpression = "SELECT * FROM Scree_Refresh_Rate";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                ScreenRefreshRate screenRefreshRate = new ScreenRefreshRate();
                screenRefreshRate.setId(resultSet.getInt(ScreenRefreshRate.ID));
                screenRefreshRate.setScreenRefreshRate(resultSet.getInt(ScreenRefreshRate.SCREEN_REFRESH_RATE));
                list.add(screenRefreshRate);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public ScreenRefreshRate getByScreenRefreshRate(int ScreenRefreshRate) {
        ScreenRefreshRate screenRefreshRate = null;
        String sqlExpression = "SELECT * FROM Scree_Refresh_Rate WHERE " + Model.ScreenRefreshRate.SCREEN_REFRESH_RATE + " = ? ";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setInt(1, ScreenRefreshRate);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                screenRefreshRate = new ScreenRefreshRate();
                screenRefreshRate.setId(resultSet.getInt(Model.ScreenRefreshRate.ID));
                screenRefreshRate.setScreenRefreshRate(resultSet.getInt(Model.ScreenRefreshRate.SCREEN_REFRESH_RATE));
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return screenRefreshRate;
    }

    @Override
    public ScreenRefreshRate getById(int id) {
        ScreenRefreshRate screenRefreshRate = null;
        String sqlExpression = "SELECT * FROM Scree_Refresh_Rate WHERE " + ScreenRefreshRate.ID + " = ? ";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                screenRefreshRate = new ScreenRefreshRate();
                screenRefreshRate.setId(resultSet.getInt(ScreenRefreshRate.ID));
                screenRefreshRate.setScreenRefreshRate(resultSet.getInt(ScreenRefreshRate.SCREEN_REFRESH_RATE));
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return screenRefreshRate;
    }

    @Override
    public void CreateScreenRefreshRate(ScreenRefreshRate screenRefreshRate) {
        String sqlExpression = "INSERT INTO Scree_Refresh_Rate (" + ScreenRefreshRate.SCREEN_REFRESH_RATE + ") VALUES (?)";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setInt(1, screenRefreshRate.getScreenRefreshRate());
            preparedStatement.execute();
            ResultSet generationKeys = preparedStatement.getGeneratedKeys();
            if (generationKeys.next()){
                int id = generationKeys.getInt(1);
                screenRefreshRate.setId(id);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateScreenRefreshRate(ScreenRefreshRate screenRefreshRate) {
        String sqlExpression = "UPDATE Scree_Refresh_Rate SET " + ScreenRefreshRate.SCREEN_REFRESH_RATE + " = ? WHERE " + ScreenRefreshRate.ID + " = ?";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setInt(1, screenRefreshRate.getId());
            preparedStatement.setInt(2, screenRefreshRate.getScreenRefreshRate());
            preparedStatement.execute();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteScreenRefreshRate(ScreenRefreshRate screenRefreshRate) {
        String sqlExpression = "DELETE FROM Scree_Refresh_Rate WHERE " + ScreenRefreshRate.ID + " = ?";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setInt(1, screenRefreshRate.getId());
            preparedStatement.execute();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
