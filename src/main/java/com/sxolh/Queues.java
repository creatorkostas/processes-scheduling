package com.sxolh;

import java.util.ArrayList;

public class Queues {
    private ArrayList<Task> tasks = new ArrayList<Task>();

    Queues(){}

    void addToQueue(Task task){tasks.add(task);}

    void removeFromQueue(){
        if(!tasks.isEmpty()) tasks.remove(0);
    }

    void updateWaitingTime(){
        for (Task task : tasks) {
            task.update();
        }
    }
}
