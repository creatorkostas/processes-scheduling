package com.sxolh;

import java.util.ArrayList;

public class Os{
    private QueuingSystem queues;
    private ArrayList<Task> done_tasks = new ArrayList<Task>();
    private boolean getNewTask = true;

    Os(int num_of_queues){
        this.queues = new QueuingSystem(num_of_queues);
    }

    void putToQueue(Task task){
        if (task == null) {
            getNewTask = false;
            return;
        }
        if(task.getTaskDone() || task.getState() == 3) {
            done_tasks.add(task);
            return;
        } 
        getNewTask = true;
        int num_of_queues = queues.getNumOfQueues();
        int priority = task.getPriority();
        int valid_priority = priority;
        if(priority>num_of_queues){valid_priority = num_of_queues;}
        else if(priority<0){priority = 0;}
        task.setPriority(valid_priority);
        queues.addToQueue(task, valid_priority);
    }
    

    Task getTaskToRun(){
        if(!getNewTask) return null;
        //Run Dispacher
        int task_id = 0;
        int queue_id = 0;
        Task task = queues.getTask(queue_id, task_id);
        queues.updateQueuesWaintingTime();
        return task;
    }

    int GetTasksNumber(){
        return queues.NumOfTasks();
    }

    void printDoneTasks(){
        try {
            for (Task done_task : done_tasks) {
                System.out.println("---------------------------------------------------");
                System.out.println(done_task.toString());
            }
        } catch (NullPointerException e) {
            System.out.println("No task is done!");
            return;
        }
        
        return;
    }
}
