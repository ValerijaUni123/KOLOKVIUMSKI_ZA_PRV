package ZADACA20;

public class TaskRunner ??? {
public void run(TaskScheduler???? scheduler, T[] tasks) {
    List<T> order = scheduler.schedule(tasks);
    order.forEach(System.out::println);
}
}