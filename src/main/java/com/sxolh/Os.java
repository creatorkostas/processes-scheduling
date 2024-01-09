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
            getNewTask = true;
            return;
        }
        if(task.getFirstResponce()) {
            getNewTask=true;
            int num_of_queues = queues.getNumOfQueues();
            int priority = task.getPriority()-1;
            int valid_priority = priority;
            if(priority>num_of_queues){valid_priority = num_of_queues;}
            if(priority<=0){valid_priority = 0;}
            task.setPriority(valid_priority);
            queues.addToQueue(task, valid_priority);
        } else{
            int num_of_queues = queues.getNumOfQueues();
            int priority = task.getPriority();
            int valid_priority = priority;
            if(priority>num_of_queues){valid_priority = num_of_queues;}
            else if(priority<=0){valid_priority = 0;}
            task.setPriority(valid_priority);
            queues.addToQueue(task, valid_priority);
        }
        
    }

    boolean getGetNewTask(){return getNewTask;}
    

    Task getTaskToRun(){
        if(!getNewTask) return null;
        //Run Dispacher
        int task_id = 0;
        int queue_id = 0;
        for (int i=0; i<queues.getNumOfQueues();i++) {
            if(queues.queues.get(i).getNumOfTask() != 0){ queue_id = i; break;}
        }
        Task task = queues.getTask(queue_id, task_id);
        queues.updateQueuesWaintingTime();
        return task;
    }

    int GetTasksNumber(){
        return queues.NumOfTasks();
    }

    int getIOqueueTasks(){return queues.IOTasks();}

    int getNumOfDoneTasks(){
        int temp = 0;
        try {
            for (Task done_task : done_tasks) {
                temp++;
            }
        } catch (NullPointerException e) {
            System.out.println("No task is done!");
            return 0;
        }
        return temp;
    }

    void PrintAverages(){
        int temp = 0;
        int average_tt = 0;
        int average_responce = 0;
        try {
            for (Task done_task : done_tasks) {
                average_responce += done_task.getFirstResponceTime();
                average_tt += done_task.getExecutionTime() + done_task.getWattingTime();
                temp++;
            }
            average_responce /= temp;
            average_tt /= temp;
            System.out.println("Average response time: "+average_responce);
            System.out.println("Average turnaround time: "+average_tt);
        } catch (NullPointerException e) {
            System.out.println("No task is done!");
        }
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
    }
}
