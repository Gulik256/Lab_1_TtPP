package Model;

public class ScreenRefreshRate {

    public static final String ID = "id";
    public static final String SCREEN_REFRESH_RATE = "Screen_refresh_rate";

    private int id;
    private int ScreenRefreshRate;

    public ScreenRefreshRate() {}

    public ScreenRefreshRate(int screenRefreshRate) {
        ScreenRefreshRate = screenRefreshRate;
    }

    public ScreenRefreshRate(int id, int screenRefreshRate) {
        this.id = id;
        ScreenRefreshRate = screenRefreshRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScreenRefreshRate() {
        return ScreenRefreshRate;
    }

    public void setScreenRefreshRate(int screenRefreshRate) {
        ScreenRefreshRate = screenRefreshRate;
    }

    @Override
    public String toString() {
        return "ScreenRefreshRate{" +
                "id=" + id +
                ", ScreenRefreshRate=" + ScreenRefreshRate +
                '}';
    }

    public static class Builder{
        private ScreenRefreshRate newScreenRefreshRate;

        public Builder(){
            newScreenRefreshRate = new ScreenRefreshRate();
        }

        public Builder addScreenRefreshRate(int screenRefreshRate){
            newScreenRefreshRate.ScreenRefreshRate = screenRefreshRate;
            return this;
        }

        public ScreenRefreshRate build(){
            return newScreenRefreshRate;
        }
    }
}
