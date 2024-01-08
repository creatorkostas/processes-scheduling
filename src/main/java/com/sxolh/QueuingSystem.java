package com.sxolh;

import java.util.ArrayList;

public class QueuingSystem {
    ArrayList<Queue> queues = new ArrayList<Queue>();
    IOQueue ioQueue = new IOQueue();

    QueuingSystem(int num_of_queues){
        for(int i=0;i<=num_of_queues;i++){ queues.add(new Queue());}
    }

    void addToQueue(Task task, int priority){
        if(task.getState() == 1) ioQueue.addToQueue(task);
        else{
            // int priority = Os.putToQueue(task, queues.size()-1);
            queues.get(priority).addToQueue(task);
        }
    }

    void updateQueuesWaintingTime(){
        for (Queue queue : queues) {
            queue.updateWaitingTime();
        }
        Task task = ioQueue.update();
        if(task != null) addToQueue(task, task.getPriority());
    }

    int getNumOfQueues(){return queues.size();}

    Task getTask(int queue_id, int task_id){
        return queues.get(queue_id).getFromQueue(task_id);
    }

    int IOTasks(){return ioQueue.getNumOfTask();}

    int NumOfTasks(){
        int temp = 0;
        for (Queue queue : queues) {
            temp += queue.getNumOfTask();
        }
        return temp;
    }
}
