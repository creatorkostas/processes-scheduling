package com.sxolh;

public class Os{
    private QueuingSystem queues;
    private boolean getNewTask = true;

    Os(int num_of_queues){
        this.queues = new QueuingSystem(num_of_queues);
    }

    void putToQueue(Task task){
        if (task == null) {
            getNewTask = false;
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
}
