package JavaPrograms;
import java.io.*;
import java.util.*;

//(CSES) USACO Guide Section "Greedy Algorithms with Sorting"

public class MovieFestival2 {
    public static class Movie implements Comparable<Movie>{
        int start, end;
        Movie(int start, int end){
            this.start = start;
            this.end = end;
        }
        public int compareTo(Movie o) {
            if (this.end == o.end){
                return -Integer.compare(this.start, o.start);
            }
            return Integer.compare(this.end, o.end);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String s = read.readLine(); String[] arr = s.split(" ");
        int n = Integer.parseInt(arr[0]), k = Integer.parseInt(arr[1]);

        Movie[] movies = new Movie[n];
        for (int i = 0; i < n; i ++){
            s = read.readLine(); arr = s.split(" ");
            movies[i] = new Movie(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
        }
        Arrays.sort(movies);

        int maxMovies = 0;
        int currentMembers = 0;
        TreeMap<Integer, Integer> maxEnds = new TreeMap<>();
        for (int i = 0; i < n; i ++){
            Integer closestEnd = maxEnds.floorKey(movies[i].start);
            if (closestEnd != null){
                maxMovies ++;
                if (maxEnds.get(closestEnd) > 1) maxEnds.put(closestEnd, maxEnds.get(closestEnd) - 1);
                else maxEnds.remove(closestEnd);
                maxEnds.put(movies[i].end, maxEnds.getOrDefault(movies[i].end,0) + 1);
            }
            else if (currentMembers < k){
                maxMovies ++;
                maxEnds.put(movies[i].end, maxEnds.getOrDefault(movies[i].end,0) + 1);
                currentMembers ++;
            }
        }
        System.out.println(maxMovies);
    }
}
