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
    private boolean done = false;
    private int state = 0;

    Task(int arival_time, int execution_time, int priority, ArrayList<Integer> io){
        this.priority = priority;
        this.execution_time = execution_time;
        this.time_remaining = execution_time;
        this.arival_time = arival_time;
        this.waiting_time = 0;
        this.step = -1;
        this.io = io;
    }

    int execute(){
        // if(waiting_time != 0) waiting_time -= 1; //Because before this execute the update but for this task is not supposed
        if (!first_responce) {
            this.first_responce_time = waiting_time;
            first_responce = true;
        }
        time_remaining = time_remaining - 1;
        step += 1;
        if(io.contains(step)) { return 1;}
        if(time_remaining == 0) return 3; //done
        return 0;
    }

    void max_q(){}

    void update(){
        waiting_time += 1;
    }



    int getPriority(){return priority;}
    int getState(){return state;}
    int getArivalTime(){return arival_time;}
    void setPriority(int priority){this.priority = priority;}
    void setTaskDone(){this.done = true;}
    void setState(int state){this.state = state;}
    boolean getTaskDone(){return this.done;}

    @Override
    public String toString(){
        return  "execution_time: "+ execution_time +
                "\nstep: "+ (step +1) +
                "\ntime_remaining: "+ time_remaining +
                "\nwaiting_time: "+ waiting_time +
                "\narival_time: "+ arival_time +
                "\nfirst_responce_time: "+ first_responce_time +
                "\nfirst_responce: "+ first_responce +
                "\npriority: "+ priority +
                "\nio: "+ io +
                "\ndone: "+ done +
                "\nstate: "+ state;
    }

}
