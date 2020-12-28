package ProtectionProxy;

import DAO.DiagonalMatrixDao;
import Impl.DiagonalMatrixDaoImpl;
import Model.DiagonalMatrix;
import Model.Users;

import java.util.List;

public class DiagonalMatrixProxy  implements DiagonalMatrixDao {

    private Users users;
    private DiagonalMatrixDao diagonalMatrixDao;

    public DiagonalMatrixProxy(Users users) {
        this.users = users;
        this.diagonalMatrixDao = new DiagonalMatrixDaoImpl();
    }

    @Override
    public List<DiagonalMatrix> getAllDiagonalMatrix() {
        return diagonalMatrixDao.getAllDiagonalMatrix();
    }

    @Override
    public DiagonalMatrix getByDiagonalMatrix(int DiagonalMatrix) {
        return diagonalMatrixDao.getByDiagonalMatrix(DiagonalMatrix);
    }

    @Override
    public DiagonalMatrix getById(int id) {
        return diagonalMatrixDao.getById(id);
    }

    @Override
    public void CreateDiagonalMatrix(DiagonalMatrix diagonalMatrix) {
        if (users.getId_role() == 1) {
            diagonalMatrixDao.CreateDiagonalMatrix(diagonalMatrix);
            System.out.printf("You can use the function as you are the admin\n");
        } else {
            System.out.printf("Sorry, you are not an admin!\n");
        }
    }

    @Override
    public void updateDiagonalMatrix(DiagonalMatrix diagonalMatrix) {
        if (users.getId_role() == 1) {
            diagonalMatrixDao.updateDiagonalMatrix(diagonalMatrix);
            System.out.printf("You can use the function as you are the admin\n");
        } else {
            System.out.printf("Sorry, you are not an admin!\n");
        }
    }

    @Override
    public void deleteDiagonalMatrix(DiagonalMatrix diagonalMatrix) {
        if (users.getId_role() == 1) {
            diagonalMatrixDao.deleteDiagonalMatrix(diagonalMatrix);
            System.out.printf("You can use the function as you are the admin\n");
        } else {
            System.out.printf("Sorry, you are not an admin!\n");
        }
    }
}
