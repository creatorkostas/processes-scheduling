package project;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Dispacher  {
    class Process {
    String name;
    int burst;
    int timeQuantum=2;
        public Process(String name, int burst) {
            this.name = name;
            this.burst = burst;
        }
    }
    
     public class RoundRobin {
         Queue <Process> processQueue= new LinkedList<>();
         
         // add processes
         
     }
     /*Scanner scanner= new Scanner(System.in);
     System.out.println("Give time quantum: ");
     int quantum=scanner.nextInt();
     */
     int quantum=2;
     
   
     //? simulateRoundRobin(processQueue,quantum,remaining_time);
    
    
    public static void simulateRoundRobin(Queue <Process> processQueue,int quantum,int remaining_time){

        while (!processQueue.isEmpty()){
            //prwto process
            Process currentProcess= processQueue.poll();
            //execution_time - time_remaining= io_time;
            remaining_time= currentProcess.burst-quantum;
            if ( remaining_time>0 ){
                System.out.println("executed of X units");
                //prosthiki sthn oura updated
                //processQueue.add(new Process(currentProcess.name,remaining_time));
            }
            else{
                System.out.println("executed for x units and done");
            }
                
            }
        }
    
}
