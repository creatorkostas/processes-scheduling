package com.sxolh;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    static private int num_of_tasks = 2;
    static private int num_of_queues = 2;
    static private int max_arrival_time = 2;
    static private int max_execution_time = 2;
    static private int max_IO_operations = 2;


    public static void main(String[] args) {
        //TODO fix rundom negative numbers
        System.out.println("Hello world!");

        //Create the tasks
        ArrayList<Task> tasks = new ArrayList<Task>();
        ArrayList<Integer> oi = new ArrayList<Integer>();
        int num_of_io_operations;
        int arival_time;
        int execution_time;
        int priority;
        for(int i=0;i<=num_of_tasks;i++){ 
            num_of_io_operations = new Random().nextInt(max_IO_operations);
            arival_time = new Random().nextInt(max_arrival_time);
            execution_time = new Random().nextInt(max_execution_time);
            priority = new Random().nextInt(num_of_queues);
            for(int j=0;j<num_of_io_operations;j++){
                oi.add(new Random().nextInt(execution_time));
            }
            tasks.add(new Task(arival_time, execution_time, priority, oi));
        }

        //Create the queues
        Os os = new Os(num_of_queues);

        Cpu cpu = new Cpu(2);
        Task cpu_task;
        
        //Run
        int cycle = 0;
        Task task_to_run = null;
        while (true) {
            System.out.println(cycle);
            //If the arrival time from the task has come put the task into the correct queue
            for(Task task: tasks){
                if(task.getArivalTime() == cycle){
                    os.putToQueue(task);
                }
            }
            
            task_to_run = os.getTaskToRun();
            System.out.println(task_to_run.hashCode());
            //Update the waiting time of the tasks
            // queues.updateQueuesWaintingTime(); //Went to OS functionality
            
            //the dispacher get a task from the queue and put it in the cpu and remove it form the queue

            cpu.addTask(task_to_run);
            
            cpu_task = cpu.run();
            os.putToQueue(cpu_task);
            //Task has todo IO operation or Q time in effect
            // if(cpu_res == 2 || cpu_res == 1) queues.addToQueue(null);            
            cycle++;
        }
    }
}