package com.sxolh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    static private int num_of_tasks = 5;
    static private int num_of_queues = 1;
    static private int max_arrival_time = 10;
    static private int max_execution_time = 15;
    static private int max_IO_operations = 8;
    static private int max_cycle = 1000;

    static ArrayList<Integer> TiedUpIO(ArrayList<Integer> io){
        ArrayList<Integer> temp;
        temp = io;
        Collections.sort(temp);
        return temp;
    }


    public static void main(String[] args) {
        //TODO fix rundom negative numbers
        
        //Create the tasks
        ArrayList<Task> tasks = new ArrayList<Task>();
        ArrayList<Integer> io = new ArrayList<Integer>();
        int num_of_io_operations;
        int arival_time;
        int execution_time;
        int priority;
        for(int i=0;i<=num_of_tasks;i++){ 
            io = new ArrayList<Integer>();
            num_of_io_operations = new Random().nextInt(max_IO_operations);
            arival_time = new Random().nextInt(max_arrival_time);
            execution_time = new Random().nextInt(max_execution_time)+1;
            priority = new Random().nextInt(num_of_queues);
            for(int j=0;j<num_of_io_operations;j++){
                io.add(new Random().nextInt(execution_time));
            }

            io = TiedUpIO(io);
            tasks.add(new Task(arival_time, execution_time, priority, io));
        }

        //Create the queues
        Os os = new Os(num_of_queues);

        Cpu cpu = new Cpu(2);
        Task cpu_task;
        
        int done_tasks = 0;
        //Run
        int cycle = 0;
        Task task_to_run = null;
        System.out.println("Hello world!");
        while (true) {
            System.out.println(cycle);
            //If the arrival time from the task has come put the task into the correct queue

            for(Task task: tasks){
                if(task.getArivalTime() == cycle){
                    os.putToQueue(task);
                }
                if(task.getTaskDone()){done_tasks++;}
            }
            if (max_cycle == cycle) {
                break;
            }
            if(done_tasks == num_of_tasks){break;}
            if (os.GetTasksNumber() == 0) {
                cycle++;
                continue;
            }
            
            task_to_run = os.getTaskToRun();
            // System.out.println(task_to_run.hashCode());
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
        for(Task task: tasks){
            System.out.println("----------------------------------------------");
            System.out.println(task.toString());
        }
        os.printDoneTasks();
    }
}