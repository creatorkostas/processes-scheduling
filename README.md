# processes-scheduling

To this simulation you must clone the repository and run the command ```(with this method you can change Globals)```
``` bash
java -cp processes-scheduling/target/classes com.sxolh.Main 
```
or run
```bash
java -jar ./processes-scheduling.jar
```

## Globals
 - ```CODED_TASKS``` : Use hard coded task in Main.java
 - ```AUTO``` : Generate random values bases on the info of the below valiables
 - ```NUM_OF_TASK``` : Number of task to generate
 - ```NUM_OF_QUEUES``` : Max priority for the tasks
 - ```MAX_Q``` : CPU quantum time
 - ```MAX_ARRIVAL_TIME``` : Max allowed arrival time
 - ```MAX_EXECUTION_TIME``` : Max allowed exuecution time
 - ```MAX_IO_OPERATIONS``` : Max allowed IO operetions present in a task
 - ```MAX_CYCLE``` : Max simulation cycle

### Disclaimer
Some times a process does not come out of IO queue because it execute the IO in random time
