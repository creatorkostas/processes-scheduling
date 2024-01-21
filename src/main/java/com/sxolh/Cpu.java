package com.sxolh;

public class Cpu {
    private int q;
    private int current_q = 0; 
    private Task task;

    Cpu(int q){
        this.q = q; //yes
    }

    void addTask(Task task){
        if(task != null){
            this.task = task;
            this.current_q = 0;
        }
    }

    Task run(int cycle){
        Task temp;
        // if (task == null) {
        //     return null;
        // }
        int responce = this.task.execute(cycle);
        if (responce == 1) { //IO operation
            this.task.setState(1);
            
            temp = this.task;
            this.task = null;
            return temp;
        }
        else if(responce == 3) { //done
            this.task.setState(3);
            this.task.setTaskDone();
            temp = this.task;
            this.task = null;
            return temp;
        }
        else if(current_q == q) {
            this.task.setState(2);

            temp = this.task;
            this.task = null;
            return temp;
        }
        else{
            current_q += 1;
            this.task.setState(0);
            if(current_q == q) {
                this.task.setState(2);

                temp = this.task;
                this.task = null;
                return temp;
            }
            return null;
        }
    }

}
