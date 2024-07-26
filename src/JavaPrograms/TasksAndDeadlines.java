package JavaPrograms;
import java.io.*;
import java.util.Arrays;

//(CSES) USACO Guide Section "Greedy Algorithms with Sorting"

public class TasksAndDeadlines {
    public static class Task implements Comparable<Task>{
        int time, deadLine;
        public Task(int time, int deadLine){
            this.time = time;
            this.deadLine = deadLine;
        }
        public int compareTo(Task a){
            return Integer.compare(this.time, a.time);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(read.readLine());

        Task[] tasks = new Task[n];
        for (int i = 0; i < n; i ++){
            String s = read.readLine(); String[] arr = s.split(" ");
            tasks[i] = new Task(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
        }
        Arrays.sort(tasks);

        long reward = 0, currentTime = 0;
        for (Task task : tasks){
            currentTime += task.time;
            reward += task.deadLine - currentTime;
        }
        System.out.println(reward);
    }
}
