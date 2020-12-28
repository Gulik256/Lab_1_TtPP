package ProtectionProxy;

import DAO.ScreenRefreshRateDao;
import Impl.ScreenRefreshRateDaoImpl;
import Model.ScreenRefreshRate;
import Model.Users;

import java.util.List;

public class ScreenRefreshRateProxy implements ScreenRefreshRateDao {

    private Users users;
    private ScreenRefreshRateDao screenRefreshRateDao;

    public ScreenRefreshRateProxy(Users users) {
        this.users = users;
        this.screenRefreshRateDao = new ScreenRefreshRateDaoImpl();
    }


    @Override
    public List<ScreenRefreshRate> getAllScreenRefreshRate() {
        return screenRefreshRateDao.getAllScreenRefreshRate();
    }

    @Override
    public ScreenRefreshRate getByScreenRefreshRate(int ScreenRefreshRate) {
        return screenRefreshRateDao.getByScreenRefreshRate(ScreenRefreshRate);
    }

    @Override
    public ScreenRefreshRate getById(int id) {
        return screenRefreshRateDao.getById(id);
    }

    @Override
    public void CreateScreenRefreshRate(ScreenRefreshRate screenRefreshRate) {
        if (users.getId_role() == 1) {
            screenRefreshRateDao.CreateScreenRefreshRate(screenRefreshRate);
            System.out.printf("You can use the function as you are the admin\n");
        } else {
            System.out.printf("Sorry, you are not an admin!\n");
        }
    }

    @Override
    public void updateScreenRefreshRate(ScreenRefreshRate screenRefreshRate) {
        if (users.getId_role() == 1) {
            screenRefreshRateDao.updateScreenRefreshRate(screenRefreshRate);
            System.out.printf("You can use the function as you are the admin\n");
        } else {
            System.out.printf("Sorry, you are not an admin!\n");
        }
    }

    @Override
    public void deleteScreenRefreshRate(ScreenRefreshRate screenRefreshRate) {
        if (users.getId_role() == 1) {
            screenRefreshRateDao.deleteScreenRefreshRate(screenRefreshRate);
            System.out.printf("You can use the function as you are the admin\n");
        } else {
            System.out.printf("Sorry, you are not an admin!\n");
        }
    }
}
