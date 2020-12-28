package DAO;

interface IDaoFactory {

    AspectRatioDao GetAspectRatioDao();
    DiagonalMatrixDao GetDiagonalMatrixDao();
    MatrixTypeDao GetMatrixTypeDao();
    MonitorDao GetMonitorDao();
    ScreenRefreshRateDao GetScreeRefreshRateDao();
    ScreenResolutionDao GetScreenResolutionDao();
    UsersDao GetUsersDao();
    RolesDao GetRolesDao();


}

