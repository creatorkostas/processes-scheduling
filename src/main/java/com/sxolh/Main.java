package com.sxolh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {


    static ArrayList<Integer> TiedUpIO(ArrayList<Integer> io){
        ArrayList<Integer> temp;
        temp = io;
        Collections.sort(temp);
        return temp;
    }


    public static void main(String[] args) {
        //TODO fix rundom negative numbers
        System.out.println("How many tasks to create: ");
        int num_of_tasks = UserInput.getInteger();

        System.out.println("How many priority queues to be: ");
        int num_of_queues = UserInput.getInteger();

        System.out.println("Max arrival time for the processes (-1 eg. 1->0): ");
        int max_arrival_time = UserInput.getInteger();

        System.out.println("Max execution time for the processes (-1 eg. 1->0): ");
        int max_execution_time = UserInput.getInteger();

        System.out.println("Max IO operations for the processes (-1 eg. 1->0): ");
        int max_IO_operations = UserInput.getInteger();

        System.out.println("Max CPU cycle (for not infinity runs): ");
        int max_cycle = UserInput.getInteger();

        System.out.println("CPU q (quantum) time: ");
        int MAX_Q = UserInput.getInteger();

        /*int num_of_tasks = 100;
        int num_of_queues = 5;
        int max_arrival_time = 20;
        int max_execution_time = 15;
        int max_IO_operations = 3;
        int max_cycle = 10000;
        int MAX_Q = 2;*/

        //Create the tasks
        ArrayList<Task> tasks = new ArrayList<Task>();
        ArrayList<Integer> io = new ArrayList<Integer>();
        // ArrayList<Task> done = new ArrayList<Task>();
        int num_of_io_operations;
        int arival_time;
        int execution_time;
        int priority;
        for(int i=0;i<num_of_tasks;i++){ 
            io = new ArrayList<Integer>();
            num_of_io_operations = new Random().nextInt(max_IO_operations);
            arival_time = new Random().nextInt(max_arrival_time);
            // arival_time = 1;
            execution_time = new Random().nextInt(max_execution_time)+1;
            priority = new Random().nextInt(num_of_queues);
            for(int j=0;j<num_of_io_operations;j++){
                io.add(new Random().nextInt(execution_time));
            }

            io = TiedUpIO(io);
            tasks.add(new Task(i,arival_time, execution_time, priority, io));
        }
        
        
        
        // io = new ArrayList<Integer>();
        // io.add(0);
        // tasks.add(new Task(0,0,5,4,io));
        // tasks.add(new Task(0,2,2,1,io));
        // tasks.add(new Task(0,4,10,3,io));
        // tasks.add(new Task(0,6,4,2,io));

        for(Task task: tasks) {System.out.println("----------------\n"+task.toString());}
        System.out.println("----------------");

        //Create the queues
        Os os = new Os(num_of_queues);

        Cpu cpu = new Cpu(MAX_Q);
        Task cpu_task;
        
        //Run
        int cycle = 0;
        Task task_to_run = null;
        System.out.println("-----------------------------------------");
        while (true) {
            // System.out.println(cycle);
            //If the arrival time from the task has come put the task into the correct queue
            for(int i=0; i<tasks.size();i++) {
                Task task = tasks.get(i);
                if(task.getArivalTime() == cycle){
                    os.putToQueue(task);
                }
            }
            if (max_cycle == cycle) {
                break;
            }
            if(os.getNumOfDoneTasks() == num_of_tasks){break;}
            if (os.GetTasksNumber() == 0 && os.getGetNewTask()) {
                cycle++;
                continue;
            }
            
            task_to_run = os.getTaskToRun();

            //the dispacher get a task from the queue and put it in the cpu and remove it form the queue

            cpu.addTask(task_to_run);
            
            cpu_task = cpu.run();
            os.putToQueue(cpu_task);     
            cycle++;
        }
        
        System.out.println("----------------------------------------------");
        System.out.println("CPU cycles: "+cycle);
        if(cycle == max_cycle) System.out.println("Max cycle number has reached!");
        System.out.println("Number of tasks: "+num_of_tasks);
        System.out.println("Number of finished tasks: "+os.getNumOfDoneTasks());
        os.PrintAverages();
        if(os.getNumOfDoneTasks() != num_of_tasks){
            System.out.println("----------------------------------------------");
            System.out.println("Task still in IO Queue: "+os.getIOqueueTasks());
            System.out.println("----------------------------------------------");
        }
        // os.printDoneTasks();
    }
}