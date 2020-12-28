package Memento;

import java.util.Stack;

public class MonitorHistory {
    public Stack<MonitorMemento> History;

    public Stack<MonitorMemento> getHistory() {
        return History;
    }

    private void setHistory(Stack<MonitorMemento> history) {
        History = history;
    }

    public MonitorHistory()
    {
        History = new Stack<MonitorMemento>();
    }

}
