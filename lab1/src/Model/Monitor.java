package Model;

import Memento.MonitorHistory;
import Memento.MonitorMemento;

public class Monitor {

    public static final String ID = "id";
    public static final String NAME = "Name";
    public static final String NAME_COMPANY = "Name_Company";
    public static final String FEATURES = "Features";
    public static final String MATRIX_TYPE_ID = "Matrix_types_id";
    public static final String ASPECT_RATIO_ID = "Aspect_ratio_id";
    public static final String DIAGONAL_MATRIX_ID = "Diagonal_matrix_id";
    public static final String SCREEN_RESOLUTION_ID = "Screen_resolution_id";
    public static final String SCREEN_REFRESH_RATE_ID = "Screen_refresh_rate_id";


    private static int id;
    private static String Name;
    private static String NameCompany;
    private static String Features;
    private static int MatrixTypeId;
    private static int AspectRatioId;
    private static int DiagonalMatrixId;
    private static int ScreenResolutionId;
    private static int ScreenRefreshRateId;

    public Monitor() {}

    public Monitor(String name, String nameCompany, String features,
                   int matrixTypeId, int aspectRatioId, int diagonalMatrixId, int screenResolutionId,
                   int screenRefreshRateId) {
        Name = name;
        NameCompany = nameCompany;
        Features = features;
        MatrixTypeId = matrixTypeId;
        AspectRatioId = aspectRatioId;
        DiagonalMatrixId = diagonalMatrixId;
        ScreenResolutionId = screenResolutionId;
        ScreenRefreshRateId = screenRefreshRateId;
    }

    public Monitor(int id, String name, String nameCompany, String features,
                   int matrixTypeId, int aspectRatioId, int diagonalMatrixId, int screenResolutionId,
                   int screenRefreshRateId) {
        this.id = id;
        Name = name;
        NameCompany = nameCompany;
        Features = features;
        MatrixTypeId = matrixTypeId;
        AspectRatioId = aspectRatioId;
        DiagonalMatrixId = diagonalMatrixId;
        ScreenResolutionId = screenResolutionId;
        ScreenRefreshRateId = screenRefreshRateId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNameCompany() {
        return NameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.NameCompany = NameCompany;
    }

    public String getFeatures() {
        return Features;
    }

    public void setFeatures(String features) {
        Features = features;
    }

    public int getMatrixTypeId() {
        return MatrixTypeId;
    }

    public void setMatrixTypeId(int matrixTypeId) {
        MatrixTypeId = matrixTypeId;
    }

    public int getAspectRatioId() {
        return AspectRatioId;
    }

    public void setAspectRatioId(int aspectRatioId) {
        AspectRatioId = aspectRatioId;
    }

    public int getDiagonalMatrixId() {
        return DiagonalMatrixId;
    }

    public void setDiagonalMatrixId(int diagonalMatrixId) {
        DiagonalMatrixId = diagonalMatrixId;
    }

    public int getScreenResolutionId() {
        return ScreenResolutionId;
    }

    public void setScreenResolutionId(int screenResolutionId) {
        ScreenResolutionId = screenResolutionId;
    }

    public int getScreenRefreshRateId() {
        return ScreenRefreshRateId;
    }

    public void setScreenRefreshRateId(int screenRefreshRateId) {
        ScreenRefreshRateId = screenRefreshRateId;
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "id = " + id + ", \n" +
                "Name = " + Name + ", \n" +
                "NameCompany = " + NameCompany + ", \n" +
                "Features = " + Features + ", \n" +
                "MatrixTypeId = " + MatrixTypeId + ", \n" +
                "AspectRatioId = " + AspectRatioId + ", \n" +
                "DiagonalMatrixId = " + DiagonalMatrixId + ", \n" +
                "ScreenResolutionId = " + ScreenResolutionId + ", \n" +
                "ScreenRefreshRateId = " + ScreenRefreshRateId + "\n" +
                '}';
    }

//    Builder

    public static class Builder {
//      Required parameters
        private static String Name;
        private static String NameCompany;
        private static int MatrixTypeId;
        private static int AspectRatioId;
        private static int DiagonalMatrixId;
        private static int ScreenResolutionId;
        private static int ScreenRefreshRateId;

//      Optional parameters
        private static String Features = " ";

        public Builder(String Name, String NameCompany, int MatrixTypeId,
                       int AspectRatioId, int DiagonalMatrixId, int ScreenResolutionId,
                       int ScreenRefreshRateId) {

            this.Name = Name;
            this.NameCompany = NameCompany;
            this.MatrixTypeId = MatrixTypeId;
            this.AspectRatioId = AspectRatioId;
            this.DiagonalMatrixId = DiagonalMatrixId;
            this.ScreenResolutionId = ScreenResolutionId;
            this.ScreenRefreshRateId = ScreenRefreshRateId;

        }

        public Builder Features(String features){
            Features = features;
            return this;
        }

        public Monitor build() {
            return new Monitor(this);

        }
    }

    private Monitor (Builder builder){
        Name = builder.Name;
        NameCompany = builder.NameCompany;
        Features = builder.Features;
        MatrixTypeId = builder.MatrixTypeId;
        AspectRatioId = builder.AspectRatioId;
        DiagonalMatrixId = builder.DiagonalMatrixId;
        ScreenResolutionId = builder.ScreenResolutionId;
        ScreenRefreshRateId = builder.ScreenRefreshRateId;

    }

    public MonitorMemento SaveState()
    {
        System.out.println("Saving your monitor");
        return new MonitorMemento(id, Name, NameCompany, Features,
                MatrixTypeId, AspectRatioId, DiagonalMatrixId,
                ScreenResolutionId, ScreenRefreshRateId);
    }

    public void RestoreState(MonitorMemento monitorMemento)
    {
        this.id = monitorMemento.id;
        this.Name = monitorMemento.Name;
        this.NameCompany = monitorMemento.NameCompany;
        this.Features = monitorMemento.Features;
        this.MatrixTypeId = monitorMemento.MatrixTypeId;
        this.AspectRatioId = monitorMemento.AspectRatioId;
        this.DiagonalMatrixId = monitorMemento.DiagonalMatrixId;
        this.ScreenResolutionId = monitorMemento.ScreenResolutionId;
        this.ScreenRefreshRateId = monitorMemento.ScreenRefreshRateId;
    }
}
