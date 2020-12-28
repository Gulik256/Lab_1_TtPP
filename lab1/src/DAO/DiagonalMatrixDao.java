package DAO;

import Model.DiagonalMatrix;

import java.util.List;

public interface DiagonalMatrixDao {

    List<DiagonalMatrix> getAllDiagonalMatrix();
    DiagonalMatrix getByDiagonalMatrix(int DiagonalMatrix);
    DiagonalMatrix getById(int id);
    void CreateDiagonalMatrix(DiagonalMatrix diagonalMatrix);
    void updateDiagonalMatrix(DiagonalMatrix diagonalMatrix);
    void deleteDiagonalMatrix(DiagonalMatrix diagonalMatrix);
}
