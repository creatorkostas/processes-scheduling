package com.sxolh;

public class Os{

    static int putToQueue(Task task, int num_of_queues){
        int priority = task.getPriority();
        if(priority>num_of_queues){return num_of_queues;}
        else if(priority<0){return 0;}
        return priority;
    }
}
