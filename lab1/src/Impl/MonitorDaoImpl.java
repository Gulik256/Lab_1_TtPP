package Impl;

import DAO.MonitorDao;
import Model.Monitor;
import jdbc.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MonitorDaoImpl implements MonitorDao {

    @Override
    public ArrayList<Monitor> getAllMonitors() {
        ArrayList<Monitor> list = new ArrayList<Monitor>();
        String sqlExpression = "SELECT * FROM Monitor";

        try(Connection connection = ConnectionDB.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Monitor monitor = new Monitor();
                monitor.setId(resultSet.getInt(Monitor.ID));
                monitor.setName(resultSet.getString(Monitor.NAME));
                monitor.setNameCompany(resultSet.getString(Monitor.NAME_COMPANY));
                monitor.setFeatures(resultSet.getString(Monitor.FEATURES));
                monitor.setMatrixTypeId(resultSet.getInt(Monitor.MATRIX_TYPE_ID));
                monitor.setAspectRatioId(resultSet.getInt(Monitor.ASPECT_RATIO_ID));
                monitor.setDiagonalMatrixId(resultSet.getInt(Monitor.DIAGONAL_MATRIX_ID));
                monitor.setScreenResolutionId(resultSet.getInt(Monitor.SCREEN_RESOLUTION_ID));
                monitor.setScreenRefreshRateId(resultSet.getInt(Monitor.SCREEN_REFRESH_RATE_ID));
                list.add(monitor);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public Monitor getByName(String Name) {
        Monitor monitor = null;
        String sqlExpression = "SELECT * FROM Monitor WHERE " + Monitor.NAME + " = ?";
        try (Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setString(1,monitor.getName());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                monitor = new Monitor();
                monitor.setId(resultSet.getInt(Monitor.ID));
                monitor.setName(resultSet.getString(Monitor.NAME));
                monitor.setNameCompany(resultSet.getString(Monitor.NAME_COMPANY));
                monitor.setFeatures(resultSet.getString(Monitor.FEATURES));
                monitor.setMatrixTypeId(resultSet.getInt(Monitor.MATRIX_TYPE_ID));
                monitor.setAspectRatioId(resultSet.getInt(Monitor.ASPECT_RATIO_ID));
                monitor.setDiagonalMatrixId(resultSet.getInt(Monitor.DIAGONAL_MATRIX_ID));
                monitor.setScreenResolutionId(resultSet.getInt(Monitor.SCREEN_RESOLUTION_ID));
                monitor.setScreenRefreshRateId(resultSet.getInt(Monitor.SCREEN_REFRESH_RATE_ID));
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return monitor;
    }

    @Override
    public Monitor getByCompanyName(String CompanyName) {
        Monitor monitor = null;
        String sqlExpression = "SELECT * FROM Monitor WHERE " + Monitor.NAME_COMPANY + " = ?";
        try (Connection connection = ConnectionDB.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setString(1,monitor.getNameCompany());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                monitor = new Monitor();
                monitor.setId(resultSet.getInt(Monitor.ID));
                monitor.setName(resultSet.getString(Monitor.NAME));
                monitor.setNameCompany(resultSet.getString(Monitor.NAME_COMPANY));
                monitor.setFeatures(resultSet.getString(Monitor.FEATURES));
                monitor.setMatrixTypeId(resultSet.getInt(Monitor.MATRIX_TYPE_ID));
                monitor.setAspectRatioId(resultSet.getInt(Monitor.ASPECT_RATIO_ID));
                monitor.setDiagonalMatrixId(resultSet.getInt(Monitor.DIAGONAL_MATRIX_ID));
                monitor.setScreenResolutionId(resultSet.getInt(Monitor.SCREEN_RESOLUTION_ID));
                monitor.setScreenRefreshRateId(resultSet.getInt(Monitor.SCREEN_REFRESH_RATE_ID));
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return monitor;
    }

    @Override
    public Monitor getById(int id) {
        Monitor monitor = null;
        String sqlExpression = "SELECT * FROM Monitor WHERE " + Monitor.ID + " = ?";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                monitor = new Monitor();
                monitor.setId(resultSet.getInt(Monitor.ID));
                monitor.setName(resultSet.getString(Monitor.NAME));
                monitor.setNameCompany(resultSet.getString(Monitor.NAME_COMPANY));
                monitor.setFeatures(resultSet.getString(Monitor.FEATURES));
                monitor.setMatrixTypeId(resultSet.getInt(Monitor.MATRIX_TYPE_ID));
                monitor.setAspectRatioId(resultSet.getInt(Monitor.ASPECT_RATIO_ID));
                monitor.setDiagonalMatrixId(resultSet.getInt(Monitor.DIAGONAL_MATRIX_ID));
                monitor.setScreenResolutionId(resultSet.getInt(Monitor.SCREEN_RESOLUTION_ID));
                monitor.setScreenRefreshRateId(resultSet.getInt(Monitor.SCREEN_REFRESH_RATE_ID));
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return monitor;
    }

    @Override
    public void CreateMonitor(Monitor monitor) {
        String sqlExpression = "INSERT INTO Monitor (" + Monitor.NAME + ", " + Monitor.NAME_COMPANY + ", "
                + Monitor.FEATURES + ", " + Monitor.ASPECT_RATIO_ID + ", " + Monitor.DIAGONAL_MATRIX_ID
                + ", " + Monitor.MATRIX_TYPE_ID + ", " + Monitor.SCREEN_REFRESH_RATE_ID + ", " + Monitor.SCREEN_RESOLUTION_ID
                + ") values (?, ?, ?, ?, ?, ?, ?, ?)";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setString(1, monitor.getName());
            preparedStatement.setString(2,monitor.getNameCompany());
            preparedStatement.setString(3,monitor.getFeatures());
            preparedStatement.setInt(4,monitor.getAspectRatioId());
            preparedStatement.setInt(5,monitor.getDiagonalMatrixId());
            preparedStatement.setInt(6,monitor.getMatrixTypeId());
            preparedStatement.setInt(7,monitor.getScreenRefreshRateId());
            preparedStatement.setInt(8,monitor.getScreenResolutionId());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                monitor.setId(id);

            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateMonitor(Monitor monitor) {
        String sqlExpression = "UPDATE Monitor SET " + Monitor.FEATURES + " = ? WHERE " + Monitor.ID + " = ?";
        try(Connection connection = ConnectionDB.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setString(1, monitor.getFeatures());
            preparedStatement.setInt(2, monitor.getId());
            preparedStatement.execute();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void deleteMonitor(Monitor monitor) {
        String sqlExpression = "DELETE FROM Monitor WHERE " + Monitor.ID + " = ?";
        try(Connection connection = ConnectionDB.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setInt(1, monitor.getId());
            preparedStatement.execute();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
