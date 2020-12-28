package observer;

import java.util.ArrayList;
import java.util.List;

public class MonitorsSite implements Observed{
    List<String> monitors = new ArrayList<>();
    List<Observe_> subscribers = new ArrayList<Observe_>();

    public void addMonitor (String monitor){
        this.monitors.add(monitor);
        notifyObservers();
    }

    public void removeMonitor (String monitor){
        this.monitors.remove(monitor);
        notifyObservers();
    }

    @Override
    public void addObserver(Observe_ observe_) {
        this.subscribers.add(observe_);
    }

    @Override
    public void removeObserver(Observe_ observe_) {
        this.subscribers.remove(observe_);
    }

    @Override
    public void notifyObservers() {
        for(Observe_ observe_:subscribers){
            observe_.handleEvent(this.monitors);
        }
    }
}
