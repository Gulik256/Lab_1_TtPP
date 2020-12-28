package Memento;

import Model.MatrixType;

public class MonitorMemento {
    public int id;
    public String Name;
    public String NameCompany;
    public String Features;
    public int MatrixTypeId;
    public int AspectRatioId;
    public int DiagonalMatrixId;
    public int ScreenResolutionId;
    public int ScreenRefreshRateId;

    public MonitorMemento(int id, String Name, String NameCompany, String Features,
                          int MatrixTypeId, int AspectRatioId, int DiagonalMatrixId,
                          int ScreenResolutionId, int ScreenRefreshRateId)
    {
        this.id = id;
        this.Name = Name;
        this.NameCompany = NameCompany;
        this.Features = Features;
        this.MatrixTypeId = MatrixTypeId;
        this.AspectRatioId = AspectRatioId;
        this.DiagonalMatrixId = DiagonalMatrixId;
        this.ScreenResolutionId = ScreenResolutionId;
        this.ScreenRefreshRateId = ScreenRefreshRateId;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    private void setName(String name) {
        Name = name;
    }

    public String getNameCompany() {
        return NameCompany;
    }

    private void setNameCompany(String nameCompany) {
        NameCompany = nameCompany;
    }

    public String getFeatures() {
        return Features;
    }

    private void setFeatures(String features) {
        Features = features;
    }

    public int getMatrixTypeId() {
        return MatrixTypeId;
    }

    private void setMatrixTypeId(int matrixTypeId) {
        MatrixTypeId = matrixTypeId;
    }

    public int getAspectRatioId() {
        return AspectRatioId;
    }

    private void setAspectRatioId(int aspectRatioId) {
        AspectRatioId = aspectRatioId;
    }

    public int getDiagonalMatrixId() {
        return DiagonalMatrixId;
    }

    private void setDiagonalMatrixId(int diagonalMatrixId) {
        DiagonalMatrixId = diagonalMatrixId;
    }

    public int getScreenResolutionId() {
        return ScreenResolutionId;
    }

    private void setScreenResolutionId(int screenResolutionId) {
        ScreenResolutionId = screenResolutionId;
    }

    public int getScreenRefreshRateId() {
        return ScreenRefreshRateId;
    }

    private void setScreenRefreshRateId(int screenRefreshRateId) {
        ScreenRefreshRateId = screenRefreshRateId;
    }
}
