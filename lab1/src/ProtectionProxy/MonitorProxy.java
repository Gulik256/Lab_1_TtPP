package ProtectionProxy;

import DAO.MonitorDao;
import Impl.MonitorDaoImpl;
import Model.Monitor;
import Model.Users;

import java.util.ArrayList;

public class MonitorProxy implements MonitorDao {

    private Users users;
    private MonitorDao monitorDao;

    public MonitorProxy(Users users) {
        this.users = users;
        this.monitorDao = new MonitorDaoImpl();
    }

    @Override
    public ArrayList<Monitor> getAllMonitors() {
        return monitorDao.getAllMonitors();
    }

    @Override
    public Monitor getByName(String Name) {
        return monitorDao.getByName(Name);
    }

    @Override
    public Monitor getByCompanyName(String CompanyName) {
        return monitorDao.getByCompanyName(CompanyName);
    }

    @Override
    public Monitor getById(int id) {
        return monitorDao.getById(id);
    }

    @Override
    public void CreateMonitor(Monitor monitor) {
        if (users.getId_role() == 1) {
            monitorDao.CreateMonitor(monitor);
            System.out.printf("You can use the function as you are the admin\n");
        } else {
            System.out.printf("Sorry, you are not an admin!\n");
        }
    }

    @Override
    public void updateMonitor(Monitor monitor) {
        if (users.getId_role() == 1) {
            monitorDao.updateMonitor(monitor);
            System.out.printf("You can use the function as you are the admin\n");
        } else {
            System.out.printf("Sorry, you are not an admin!\n");
        }
    }

    @Override
    public void deleteMonitor(Monitor monitor) {
        if (users.getId_role() == 1) {
            monitorDao.deleteMonitor(monitor);
            System.out.printf("You can use the function as you are the admin\n");
        } else {
            System.out.printf("Sorry, you are not an admin!\n");
        }
    }
}
