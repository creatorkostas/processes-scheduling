package com.sxolh;

import java.util.ArrayList;

public class Task {
    private int execution_time;
    private int step;
    private int time_remaining;
    private int waiting_time;
    private int arival_time;
    private int first_responce_time;
    private boolean first_responce = false;
    private int priority;
    private ArrayList<Integer> io;

    Task(int arival_time, int execution_time, int priority, ArrayList<Integer> io){
        this.priority = priority;
        this.execution_time = execution_time;
        this.time_remaining = execution_time;
        this.arival_time = arival_time;
        this.waiting_time = 0;
        this.step = 0;
        this.io = io;
    }

    int execute(){
        if(waiting_time != 0) waiting_time -= 1;
        if (!first_responce) {
            first_responce_time = waiting_time;
            first_responce = true;
        }
        step += 1;
        time_remaining -= 1;
        if(io.contains(step)) return 1;
        else return 0;
    }

    void update(){
        waiting_time += 1;
    }



    int getPriority(){return priority;}
    int getArivalTime(){return arival_time;}
    void setPriority(int priority){this.priority = priority;}

}
