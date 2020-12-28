package DAO;

import Model.ScreenRefreshRate;

import java.util.List;

public interface ScreenRefreshRateDao {

    List<ScreenRefreshRate> getAllScreenRefreshRate();
    ScreenRefreshRate getByScreenRefreshRate(int ScreenRefreshRate);
    ScreenRefreshRate getById(int id);
    void CreateScreenRefreshRate(ScreenRefreshRate screenRefreshRate);
    void updateScreenRefreshRate(ScreenRefreshRate screenRefreshRate);
    void deleteScreenRefreshRate(ScreenRefreshRate screenRefreshRate);
}
