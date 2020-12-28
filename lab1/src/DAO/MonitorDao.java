package DAO;

import Model.Monitor;

import java.util.ArrayList;

public interface MonitorDao {

    ArrayList<Monitor> getAllMonitors();
    Monitor getByName(String Name);
    Monitor getByCompanyName(String CompanyName);
    Monitor getById(int id);
    void CreateMonitor(Monitor monitor);
    void updateMonitor(Monitor monitor);
    void deleteMonitor(Monitor monitor);

}
