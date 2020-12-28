package DAO;

import Model.AspectRatio;

import java.util.List;

public interface AspectRatioDao {

    List<AspectRatio> getAllAspectRatio();
    AspectRatio getByAspectRatio(String AspectRatio);
    AspectRatio getById(int id);
    void CreateAspectRatio(AspectRatio aspectRatio);
    void updateAspectRatio(AspectRatio aspectRatio);
    void deleteAspectRatio(AspectRatio aspectRatio);
}
