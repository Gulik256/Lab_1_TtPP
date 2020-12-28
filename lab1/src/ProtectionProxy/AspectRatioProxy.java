package ProtectionProxy;

import DAO.AspectRatioDao;
import Impl.AspectRatioDaoImpl;
import Model.AspectRatio;
import Model.Users;

import java.util.List;

public class AspectRatioProxy implements AspectRatioDao {

    private Users users;
    private AspectRatioDao aspectRatioDao;

    public AspectRatioProxy(Users users) {
        this.users = users;
        this.aspectRatioDao = new AspectRatioDaoImpl();
    }

    @Override
    public List<AspectRatio> getAllAspectRatio() {
        return aspectRatioDao.getAllAspectRatio();
    }

    @Override
    public AspectRatio getByAspectRatio(String AspectRatio) {
        return aspectRatioDao.getByAspectRatio(AspectRatio);
    }

    @Override
    public AspectRatio getById(int id) {
        return aspectRatioDao.getById(id);
    }

    @Override
    public void CreateAspectRatio(AspectRatio aspectRatio) {
        if (users.getId_role() == 1) {
            aspectRatioDao.CreateAspectRatio(aspectRatio);
            System.out.printf("You can use the function as you are the admin\n");
        } else {
            System.out.printf("Sorry, you are not an admin!\n");
        }
    }

    @Override
    public void updateAspectRatio(AspectRatio aspectRatio) {
        if (users.getId_role() == 1) {
            aspectRatioDao.updateAspectRatio(aspectRatio);
            System.out.printf("You can use the function as you are the admin\n");
        } else {
            System.out.printf("Sorry, you are not an admin!\n");
        }
    }

    @Override
    public void deleteAspectRatio(AspectRatio aspectRatio) {
        if (users.getId_role() == 1) {
            aspectRatioDao.deleteAspectRatio(aspectRatio);
            System.out.printf("You can use the function as you are the admin\n");
        } else {
            System.out.printf("Sorry, you are not an admin!\n");
        }
    }
}
