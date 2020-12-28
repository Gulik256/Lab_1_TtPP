package Impl;

import DAO.MatrixTypeDao;
import Model.MatrixType;
import jdbc.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatrixTypeDaoImpl implements MatrixTypeDao {

    @Override
    public List<MatrixType> getAllMatrixType() {
        ArrayList<MatrixType> list = new ArrayList<MatrixType>();
        String sqlExpression = "SELECT * FROM Matrix_Type";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                MatrixType matrixType = new MatrixType();
                matrixType.setId(resultSet.getInt(MatrixType.ID));
                matrixType.setMatrixType(resultSet.getString(MatrixType.MATRIX_TYPE));
                list.add(matrixType);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public MatrixType getByNameMatrixType(String NameMatrixType) {
        MatrixType matrixType = null;
        String sqlExpression = "SELECT * FROM Matrix_Type WHERE " + MatrixType.MATRIX_TYPE + " = ? ";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setString(1, NameMatrixType);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                matrixType = new MatrixType();
                matrixType.setId(resultSet.getInt(MatrixType.ID));
                matrixType.setMatrixType(resultSet.getString(MatrixType.MATRIX_TYPE));
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return matrixType;
    }

    @Override
    public MatrixType getById(int id) {
        MatrixType matrixType = null;
        String sqlExpression = "SELECT * FROM Matrix_Type WHERE " + MatrixType.ID + " = ? ";
        try(Connection connection = ConnectionDB.getConnection()){
           PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
           preparedStatement.setInt(1, id);
           ResultSet resultSet = preparedStatement.executeQuery();
           while (resultSet.next()){
               matrixType = new MatrixType();
               matrixType.setId(resultSet.getInt(MatrixType.ID));
               matrixType.setMatrixType(resultSet.getString(MatrixType.MATRIX_TYPE));
           }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return matrixType;
    }

    @Override
    public void CreateMatrixType(MatrixType matrixType) {
        String sqlExpression = "INSERT INTO Diagonal_Matrix (" + MatrixType.MATRIX_TYPE + ") VALUES (?)";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setString(1, matrixType.getMatrixType());
            preparedStatement.execute();
            ResultSet generationKeys = preparedStatement.getGeneratedKeys();
            if (generationKeys.next()){
                int id = generationKeys.getInt(1);
                matrixType.setId(id);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateMatrixType(MatrixType matrixType) {
        String sqlExpression = "UPDATE Matrix_Type SET " + MatrixType.MATRIX_TYPE + " = ? WHERE " + MatrixType.ID + " = ?";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setInt(1, matrixType.getId());
            preparedStatement.setString(2, matrixType.getMatrixType());
            preparedStatement.execute();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void deleteMatrixType(MatrixType matrixType) {
        String sqlExpression = "DELETE FROM Matrix_Type WHERE " + MatrixType.ID + " = ?";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setInt(1, matrixType.getId());
            preparedStatement.execute();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
