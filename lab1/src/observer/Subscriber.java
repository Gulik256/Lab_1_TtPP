package observer;

import java.util.List;

public class Subscriber implements Observe_ {
    String name;

    public Subscriber (String name){
        this.name = name;
    }

    @Override
    public void handleEvent(List<String> monitors) {
        System.out.println("Dear" + name + "\n We have some changes in monitors:" + monitors +
                "\n==============================================================\n");
    }
}
