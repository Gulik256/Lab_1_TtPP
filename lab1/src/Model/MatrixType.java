package Model;

public class MatrixType {

    public static final String ID = "id";
    public static final String MATRIX_TYPE = "Name_type";

    private int id;
    private String MatrixType;

    public MatrixType() {}

    public MatrixType(String matrixType) {
        MatrixType = matrixType;
    }

    public MatrixType(int id, String matrixType) {
        this.id = id;
        MatrixType = matrixType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatrixType() {
        return MatrixType;
    }

    public void setMatrixType(String matrixType) {
        MatrixType = matrixType;
    }

    @Override
    public String toString() {
        return "MatrixType{" +
                "id=" + id +
                ", MatrixType='" + MatrixType + '\'' +
                '}';
    }

//    Builder
    public static class Builder{
        private MatrixType newMatrixType;

        public Builder(){
            newMatrixType = new MatrixType();
        }

        public Builder addMatrixType(String matrixType){
            newMatrixType.MatrixType = matrixType;
            return this;
        }

        public MatrixType build(){
            return newMatrixType;
        }
    }
}
