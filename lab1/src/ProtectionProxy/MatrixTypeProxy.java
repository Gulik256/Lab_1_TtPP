package ProtectionProxy;

import DAO.MatrixTypeDao;
import Impl.MatrixTypeDaoImpl;
import Model.MatrixType;
import Model.Users;

import java.util.List;

public class MatrixTypeProxy implements MatrixTypeDao {

    private Users users;
    private MatrixTypeDao matrixTypeDao;

    public MatrixTypeProxy(Users users) {
        this.users = users;
        this.matrixTypeDao = new MatrixTypeDaoImpl();
    }

    @Override
    public List<MatrixType> getAllMatrixType() {
        return matrixTypeDao.getAllMatrixType();
    }

    @Override
    public MatrixType getByNameMatrixType(String NameMatrixType) {
        return matrixTypeDao.getByNameMatrixType(NameMatrixType);
    }

    @Override
    public MatrixType getById(int id) {
        return matrixTypeDao.getById(id);
    }

    @Override
    public void CreateMatrixType(MatrixType matrixType) {
        if (users.getId_role() == 1) {
            matrixTypeDao.CreateMatrixType(matrixType);
            System.out.printf("You can use the function as you are the admin\n");
        } else {
            System.out.printf("Sorry, you are not an admin!\n");
        }
    }

    @Override
    public void updateMatrixType(MatrixType matrixType) {
        if (users.getId_role() == 1) {
            matrixTypeDao.updateMatrixType(matrixType);
            System.out.printf("You can use the function as you are the admin\n");
        } else {
            System.out.printf("Sorry, you are not an admin!\n");
        }
    }

    @Override
    public void deleteMatrixType(MatrixType matrixType) {
        if (users.getId_role() == 1) {
            matrixTypeDao.deleteMatrixType(matrixType);
            System.out.printf("You can use the function as you are the admin\n");
        } else {
            System.out.printf("Sorry, you are not an admin!\n");
        }
    }
}
