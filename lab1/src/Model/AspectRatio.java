package Model;

public class AspectRatio {

    public static final String ID = "id";
    public static final String ASPECT_RATIO = "Aspect_ratio";

    private int id;
    private String AspectRatio;

    public AspectRatio() {}

    public AspectRatio(String aspectRatio) {
        AspectRatio = aspectRatio;
    }

    public AspectRatio(int id, String aspectRatio) {
        this.id = id;
        AspectRatio = aspectRatio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAspectRatio() {
        return AspectRatio;
    }

    public void setAspectRatio(String aspectRatio) {
        AspectRatio = aspectRatio;
    }

    @Override
    public String toString() {
        return "AspectRatio{" +
                "id=" + id +
                ", AspectRatio='" + AspectRatio + '\'' +
                '}';
    }

//    Builder
    public static class Builder {

        private AspectRatio newAspectRatio;

        public Builder(){
            newAspectRatio = new AspectRatio();
        }

        public Builder addAspectRatio(String aspectRatio){
            newAspectRatio.AspectRatio = aspectRatio;
            return this;
        }

        public AspectRatio build(){
            return newAspectRatio;
        }
    }
}
