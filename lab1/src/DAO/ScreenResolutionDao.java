package DAO;

import Model.ScreenResolution;

import java.util.List;

public interface ScreenResolutionDao {

    List<ScreenResolution> getAllScreenResolution();
    ScreenResolution getByScreenRefreshRate(int ScreenResolution);
    ScreenResolution getById(int id);
    void CreateScreenResolution(ScreenResolution screenResolution);
    void updateScreenResolution(ScreenResolution screenResolution);
    void deleteScreenResolution(ScreenResolution screenResolution);
}
