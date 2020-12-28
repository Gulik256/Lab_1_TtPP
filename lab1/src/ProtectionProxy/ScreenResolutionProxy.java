package ProtectionProxy;

import DAO.ScreenResolutionDao;
import Impl.ScreenResolutionDaoImpl;
import Model.ScreenResolution;
import Model.Users;

import java.util.List;

public class ScreenResolutionProxy implements ScreenResolutionDao {

    private Users users;
    private ScreenResolutionDao screenResolutionDao;

    public ScreenResolutionProxy(Users users) {
        this.users = users;
        this.screenResolutionDao = new ScreenResolutionDaoImpl();
    }

    @Override
    public List<ScreenResolution> getAllScreenResolution() {
        return screenResolutionDao.getAllScreenResolution();
    }

    @Override
    public ScreenResolution getByScreenRefreshRate(int ScreenResolution) {
        return screenResolutionDao.getByScreenRefreshRate(ScreenResolution);
    }

    @Override
    public ScreenResolution getById(int id) {
        return screenResolutionDao.getById(id);
    }

    @Override
    public void CreateScreenResolution(ScreenResolution screenResolution) {
        if (users.getId_role() == 1) {
            screenResolutionDao.CreateScreenResolution(screenResolution);
            System.out.printf("You can use the function as you are the admin\n");
        } else {
            System.out.printf("Sorry, you are not an admin!\n");
        }
    }

    @Override
    public void updateScreenResolution(ScreenResolution screenResolution) {
        if (users.getId_role() == 1) {
            screenResolutionDao.updateScreenResolution(screenResolution);
            System.out.printf("You can use the function as you are the admin\n");
        } else {
            System.out.printf("Sorry, you are not an admin!\n");
        }
    }

    @Override
    public void deleteScreenResolution(ScreenResolution screenResolution) {
        if (users.getId_role() == 1) {
            screenResolutionDao.deleteScreenResolution(screenResolution);
            System.out.printf("You can use the function as you are the admin\n");
        } else {
            System.out.printf("Sorry, you are not an admin!\n");
        }
    }
}
