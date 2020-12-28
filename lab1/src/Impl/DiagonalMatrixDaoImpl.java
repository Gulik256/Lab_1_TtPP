package Impl;

import DAO.DiagonalMatrixDao;
import Model.AspectRatio;
import Model.DiagonalMatrix;
import jdbc.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DiagonalMatrixDaoImpl implements DiagonalMatrixDao {

    @Override
    public List<DiagonalMatrix> getAllDiagonalMatrix() {
        ArrayList<DiagonalMatrix> list = new ArrayList<DiagonalMatrix>();
        String sqlExpression = "SELECT * FROM Diagonal_Matrix";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                DiagonalMatrix diagonalMatrix = new DiagonalMatrix();
                diagonalMatrix.setId(resultSet.getInt(AspectRatio.ID));
                diagonalMatrix.setDiagonalMatrix(resultSet.getInt(DiagonalMatrix.DIAGONAL_MATRIX));
                list.add(diagonalMatrix);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public DiagonalMatrix getByDiagonalMatrix(int DiagonalMatrix) {
        DiagonalMatrix diagonalMatrix = null;
        String sqlExpression = "SELECT * FROM Diagonal_Matrix WHERE " + Model.DiagonalMatrix.DIAGONAL_MATRIX + " = ?";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setInt(1, DiagonalMatrix);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                diagonalMatrix = new DiagonalMatrix();
                diagonalMatrix.setId(resultSet.getInt(Model.DiagonalMatrix.ID));
                diagonalMatrix.setDiagonalMatrix(resultSet.getInt(Model.DiagonalMatrix.DIAGONAL_MATRIX));
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return diagonalMatrix;
    }

    @Override
    public DiagonalMatrix getById(int id) {
        DiagonalMatrix diagonalMatrix = null;
        String sqlExpression = "SELECT * FROM Diagonal_Matrix WHERE " + DiagonalMatrix.ID + " = ?";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                diagonalMatrix = new DiagonalMatrix();
                diagonalMatrix.setId(resultSet.getInt(DiagonalMatrix.ID));
                diagonalMatrix.setDiagonalMatrix(resultSet.getInt(DiagonalMatrix.DIAGONAL_MATRIX));
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return diagonalMatrix;
    }

    @Override
    public void CreateDiagonalMatrix(DiagonalMatrix diagonalMatrix) {
        String sqlExpression = "INSERT INTO Diagonal_Matrix (" + DiagonalMatrix.DIAGONAL_MATRIX + ") VALUES (?)";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setInt(1, diagonalMatrix.getDiagonalMatrix());
            preparedStatement.executeUpdate();
            ResultSet generationKeys = preparedStatement.getGeneratedKeys();
            if (generationKeys.next()){
                int id = generationKeys.getInt(1);
                diagonalMatrix.setId(id);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateDiagonalMatrix(DiagonalMatrix diagonalMatrix) {
        String sqlExpression = "UPDATE Diagonal_Matrix SET " + DiagonalMatrix.DIAGONAL_MATRIX + " = ? WHERE " + DiagonalMatrix.ID + " = ?";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setInt(1, diagonalMatrix.getId());
            preparedStatement.setInt(2, diagonalMatrix.getDiagonalMatrix());
            preparedStatement.execute();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteDiagonalMatrix(DiagonalMatrix diagonalMatrix) {
        String sqlExpression = "DELETE FROM Diagonal_Matrix WHERE " + DiagonalMatrix.ID + " = ?";
        try(Connection connection = ConnectionDB.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setInt(1, diagonalMatrix.getId());
            preparedStatement.execute();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
