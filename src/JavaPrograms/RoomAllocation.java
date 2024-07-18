package JavaPrograms;
import java.io.*;
import java.util.*;

//CSES USACO Guide Section "More on Sorted Sets"
// Does not pass all test cases

public class RoomAllocation {
    public static class Customer{
        int time, customerNum, end = 1;
        public Customer(int t, int c){
            time = t;
            customerNum = c;
        }
    }
    public static class Comp implements Comparator<Customer>{
        public int compare(Customer a, Customer b){
            if (a.time == b.time) {
                return Integer.compare(a.customerNum * a.end, b.customerNum * b.end);
            }
            return Integer.compare(a.time, b.time);
        }
    }
    public static class FastIO extends PrintWriter {
        private InputStream stream;
        private byte[] buf = new byte[1 << 16];
        private int curChar;
        private int numChars;

        // standard input
        public FastIO() {
            this(System.in, System.out);
        }

        public FastIO(InputStream i, OutputStream o) {
            super(o);
            stream = i;
        }
        private int nextByte() {
            if (numChars == -1) { throw new InputMismatchException(); }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) { throw new InputMismatchException(); }
                if (numChars == -1) {
                    return -1;  // end of file
                }
            }
            return buf[curChar++];
        }
        public String next() {
            int c;
            do { c = nextByte(); } while (c <= ' ');

            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = nextByte();
            } while (c > ' ');
            return res.toString();
        }
    }
    public static void main(String[] args) throws Exception{
        FastIO read = new FastIO();
        int N = Integer.parseInt(read.next());
        PriorityQueue<Integer> openRooms = new PriorityQueue<>();
        Customer[] times = new Customer[2 * N];
        for (int i = 0; i < N; i ++){
            String[] arr = new String[2];
            arr[0] = read.next(); arr[1] = read.next();
            times[2 * i] = new Customer(Integer.parseInt(arr[0]), i + 1);
            times[2 * i + 1] = new Customer(Integer.parseInt(arr[1]), i + 1);
            times[2 * i + 1].end = N + 1;
            openRooms.add(i + 1);
        }
        Arrays.sort(times, new Comp());
        int k = 0;
        int[] ans = new int[N];
        PriorityQueue<Integer> runningRooms = new PriorityQueue<>();
        for (Customer time: times){
            if (runningRooms.contains(time.customerNum)) {
                runningRooms.remove(time.customerNum);
                openRooms.add(ans[time.customerNum - 1]);
            }
            else {
                runningRooms.add(time.customerNum);
                ans[time.customerNum - 1] = openRooms.peek();
                openRooms.poll();
                k = Math.max(k, ans[time.customerNum - 1]);
            }
        }
        System.out.println(k);
        StringBuilder sb = new StringBuilder();
        for (int t : ans){
            sb.append(t).append(" ");
        }
        System.out.println(sb);
    }
}
