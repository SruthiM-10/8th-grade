package USACOPrograms;

import java.io.*;
import java.util.TreeSet;

//USACO 2015 Dec Contest, Silver

public class HighCardWins {
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader(new FileReader("highcard.in"));
        BufferedWriter write = new BufferedWriter(new FileWriter("highcard.out"));
        int n = Integer.parseInt(read.readLine());

        TreeSet<Integer> bessieCards = new TreeSet<>();
        for (int i = 1; i <= 2 * n; i ++) bessieCards.add(i);

        int[] elsieCards = new int[n];
        for (int i = 0; i < n; i ++){
            elsieCards[i] = Integer.parseInt(read.readLine());
            bessieCards.remove(elsieCards[i]);
        }

        int points = 0;
        for (int card : elsieCards){
            if (bessieCards.higher(card) != null) {
                points++;
                bessieCards.remove(bessieCards.higher(card));
            }
            else bessieCards.remove(bessieCards.first());
        }
        write.write(points + "");
        write.close();
    }
}
