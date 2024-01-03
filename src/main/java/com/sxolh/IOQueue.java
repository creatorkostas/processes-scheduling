package com.sxolh;

import java.util.Random;

public class IOQueue extends Queue {

    Task update() {
        Task temp = null;
        if (this.getNumOfTask() != 0) {
            int i = new Random().nextInt(2);
            if(i==1) temp = this.getFromQueue(0);
        }
        this.updateWaitingTime();
        return temp;
    }

    @Override
    Task getFromQueue(int task_id) {
        // TODO Auto-generated method stub
        Task task = super.getFromQueue(task_id);
        task.setState(0);
        return task;
    }
}
