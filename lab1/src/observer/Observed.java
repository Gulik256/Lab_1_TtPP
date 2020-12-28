package observer;

public interface Observed {
    public void addObserver(Observe_ observe_);

    public void removeObserver(Observe_ observe_);

    public void notifyObservers();
}
