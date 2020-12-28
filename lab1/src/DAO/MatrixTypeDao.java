package DAO;


import Model.MatrixType;

import java.util.List;

public interface MatrixTypeDao {

    List<MatrixType> getAllMatrixType();
    MatrixType getByNameMatrixType(String NameMatrixType);
    MatrixType getById(int id);
    void CreateMatrixType(MatrixType matrixType);
    void updateMatrixType(MatrixType matrixType);
    void deleteMatrixType(MatrixType matrixType);
}
