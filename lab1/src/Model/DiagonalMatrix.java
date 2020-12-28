package Model;

public class DiagonalMatrix {

    public static final String ID = "id";
    public static final String DIAGONAL_MATRIX = "Diagonal_Matrix";

    private int id;
    private int DiagonalMatrix;

    public DiagonalMatrix() {}

    public DiagonalMatrix(int diagonalMatrix) {
        DiagonalMatrix = diagonalMatrix;
    }

    public DiagonalMatrix(int id, int diagonalMatrix) {
        this.id = id;
        DiagonalMatrix = diagonalMatrix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDiagonalMatrix() {
        return DiagonalMatrix;
    }

    public void setDiagonalMatrix(int diagonalMatrix) {
        DiagonalMatrix = diagonalMatrix;
    }

    @Override
    public String toString() {
        return "DiagonalMatrix{" +
                "id=" + id +
                ", DiagonalMatrix=" + DiagonalMatrix +
                '}';
    }

//    Builder
    public static class Builder{

        private DiagonalMatrix newDiagonalMatrix;

        public Builder(){
            newDiagonalMatrix = new DiagonalMatrix();
        }

        public Builder addDiagonalMatrix(int diagonalMatrix){
            newDiagonalMatrix.DiagonalMatrix = diagonalMatrix;
            return this;
        }

        public DiagonalMatrix build(){
            return newDiagonalMatrix;
        }
    }
}
