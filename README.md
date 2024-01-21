# processes-scheduling

To this simulation you must clone the repository and run the command
```bash
java -jar ./processes-scheduling.jar
```

### Setting
Here you can change the simulation's setting
 - ```coded_tasks (Default: true)``` : Use hard coded task in Main.java
 - ```auto (Default: true)``` : Generate random values bases on the info of the below valiables
 - ```max_cycle (Default: 999)``` : Max simulation cycle
 - ```quantum_time (Default: 2)``` : CPU quantum time
 - ```num_of_tasks (Default: 10)``` : Number of task to generate
 - ```num_of_queues (Default: 4)``` : Max priority for the tasks
 - ```max_arrival_time (Default: 10)``` : Max allowed arrival time
 - ```max_execution_time (Default: 20)``` : Max allowed exuecution time
 - ```max_IO_operations (Default: 3)``` : Max allowed IO operetions present in a task

### Disclaimer
Some times a process does not come out of IO queue because it execute the IO in random time
