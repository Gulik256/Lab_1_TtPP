package Model;

public class ScreenResolution {

    public static final String ID = "id";
    public static final String SCREEN_RESOLUTION = "Screen_resolution";

    private int id;
    private int ScreenResolution;

    public ScreenResolution() {}

    public ScreenResolution(int screenResolution) {
        ScreenResolution = screenResolution;
    }

    public ScreenResolution(int id, int screenResolution) {
        this.id = id;
        ScreenResolution = screenResolution;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScreenResolution() {
        return ScreenResolution;
    }

    public void setScreenResolution(int screenResolution) {
        ScreenResolution = screenResolution;
    }

    @Override
    public String toString() {
        return "ScreenResolution{" +
                "id=" + id +
                ", ScreenResolution=" + ScreenResolution +
                '}';
    }

//    Builder

    public static class Builder{
        private ScreenResolution newScreenResolution;

        public Builder(){
            newScreenResolution = new ScreenResolution();
        }

        public Builder addScreenResolution(int screenResolution){
            newScreenResolution.ScreenResolution = screenResolution;
            return this;
        }

        public ScreenResolution build(){
            return newScreenResolution;
        }
    }
}
