package com.sxolh;

import java.util.ArrayList;

public class Globals {
    //To use hard codded Task (in Main.java) set AUTO to True and CODED_TASKS to True
    
    public static Boolean AUTO = true;
    public static Boolean CODED_TASKS = true;
    
    public static int NUM_OF_TASK = 10;
    public static int NUM_OF_QUEUES = 4;
    public static int MAX_Q = 2;
    public static int MAX_ARRIVAL_TIME = 10;
    public static int MAX_EXECUTION_TIME = 20;
    public static int MAX_IO_OPERATIONS = 2;
    public static int MAX_CYCLE = 100;
    

    //TODO fix initialations FOR NOW THE TASK GO IN Main.java
    public static ArrayList<Task> tasks = new ArrayList<Task>(){{
        // task_id, arival_time, execution_time, priority, io_operation_time (Integer)
            new Task(0,0,5,4,new ArrayList<Integer>(){{}} );
            new Task(1,2,2,1,new ArrayList<Integer>(){{}} );
            new Task(2,4,10,3,new ArrayList<Integer>(){{}} );
            new Task(3,6,4,2,new ArrayList<Integer>(){{}} );   
    }};
}
