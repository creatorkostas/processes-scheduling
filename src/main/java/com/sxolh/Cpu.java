package com.sxolh;

public class Cpu {
    private int q;
    private int current_q = 0; 
    private Task task;

    Cpu(int q){
        this.q = q;
    }

    void addTask(Task task){this.task = task;}

    int run(){
        int responce = task.execute();
        current_q += 1;
        if (responce == 1) {
            task = null;
            return 2;
        }
        else if(current_q == q) {
            task=null;
            return 1;
        };

        return 0;
    }

}
