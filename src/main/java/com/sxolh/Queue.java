package com.sxolh;

import java.util.ArrayList;

public class Queue {
    private ArrayList<Task> tasks = new ArrayList<Task>();

    Queue(){}

    void addToQueue(Task task){tasks.add(task);}

    void updateWaitingTime(){
        for (Task task : tasks) {
            task.update();
        }
    }

    Task getFromQueue(int task_id){
        if(tasks.size() == 0) return null;
        Task temp = tasks.get(task_id);
        tasks.remove(task_id);
        return temp;
    }

    int getNumOfTask(){return tasks.size();}
}
