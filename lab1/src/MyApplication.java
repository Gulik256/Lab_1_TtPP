import DAO.*;
import Impl.DiagonalMatrixDaoImpl;
import Impl.MonitorDaoImpl;
import Impl.ScreenResolutionDaoImpl;
import Impl.UsersImpl;
import Memento.MonitorHistory;
import Memento.MonitorMemento;
import Model.DiagonalMatrix;
import Model.Monitor;
import Model.ScreenResolution;
import Model.Users;
import ProtectionProxy.MonitorProxy;
import jdbc.ConnectionDB;
import observer.MonitorsSite;
import observer.Observe_;
import observer.Subscriber;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class MyApplication {
    public static void main(String[] args) {
        try{
            DaoFactory daoFactory = new DaoFactory();

//        MonitorsSite monitorsSite = new MonitorsSite();
//
//        monitorsSite.addMonitor("testFistMonitor");
//        monitorsSite.addMonitor("testSecondMonitor");
//
//        Observe_ firstSubscribes = new Subscriber("Dmitri");
//        Observe_ secondSubscribes = new Subscriber("Lana");
//
//        monitorsSite.addObserver(firstSubscribes);
//        monitorsSite.addObserver(secondSubscribes);
//
//        monitorsSite.addMonitor("test");

//            daoFactory.GetMonitorDao().getById(1);
//
//
//            Monitor monitor = new Monitor.Builder("Taya", "Sony",
//                                                1, 1, 1,
//                                                1, 1)
//                    .Features("HDMI")
//                    .build();
//
//            MonitorHistory monitorHistory = new MonitorHistory();
//
//            System.out.println(monitor);
//            monitorHistory.History.push(monitor.SaveState());
//
//            DiagonalMatrix diagonalMatrix = new DiagonalMatrix.Builder()
//                    .addDiagonalMatrix(32)
//                    .build();
//
//            ScreenResolution screenResolution = new ScreenResolution.Builder()
//                    .addScreenResolution(720)
//                    .build();
//
//            System.out.println(screenResolution);

//            System.out.println(daoFactory.GetMonitorDao().getAllMonitors());
//            daoFactory.GetDiagonalMatrixDao().CreateDiagonalMatrix(diagonalMatrix);
//            daoFactory.GetScreenResolutionDao().CreateScreenResolution(screenResolution);


            Scanner in = new Scanner(System.in);
            UsersDao usersDao = new UsersImpl();
            System.out.println("Выберете действие!");
            System.out.println("1 - Войти");//TODO create signIn
            System.out.println("2 - Регистрация");//TODO create registration
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Вход");
//                    Monitor monitor = new Monitor.Builder("Taya", "Sony",
//                                                1, 1, 1,
//                                                1, 1)
//                    .Features("HDMI")
//                    .build();
//                    MonitorDao monitor1 = new MonitorProxy(new Users(2,"Test2","Test2",1));
//                    monitor1.CreateMonitor(monitor);
//
//                    MonitorDao monitor2 = new MonitorProxy(new Users(3,"Test3","Test3",2));
//                    monitor1.CreateMonitor();
                    usersDao.LogIn();
//                    daoFactory.GetUsersDao().LogIn();
                    break;
                case 2:
                    System.out.println("Регистрация");
                    usersDao.Registration();
//                    daoFactory.GetUsersDao().Registration();
                    break;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
