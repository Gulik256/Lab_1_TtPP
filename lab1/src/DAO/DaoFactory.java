package DAO;


import Impl.*;

public class DaoFactory implements IDaoFactory {

    @Override
    public AspectRatioDao GetAspectRatioDao() {
        return new AspectRatioDaoImpl();
    }

    @Override
    public DiagonalMatrixDao GetDiagonalMatrixDao() {
        return new DiagonalMatrixDaoImpl();
    }

    @Override
    public MatrixTypeDao GetMatrixTypeDao() {
        return new MatrixTypeDaoImpl();
    }

    @Override
    public MonitorDao GetMonitorDao() {
        return new MonitorDaoImpl();
    }

    @Override
    public ScreenRefreshRateDao GetScreeRefreshRateDao() {
        return new ScreenRefreshRateDaoImpl();
    }

    @Override
    public ScreenResolutionDao GetScreenResolutionDao() {
        return new ScreenResolutionDaoImpl();
    }

    @Override
    public UsersDao GetUsersDao() {
        return new UsersImpl();
    }

    @Override
    public RolesDao GetRolesDao() {
        return new RolesImpl();
    }


}
