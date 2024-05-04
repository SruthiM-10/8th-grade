package ACSLPrograms;
import java.util.*;

public class ACSLBook {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        String message = scan.nextLine();
        ArrayList<ArrayList<String>> paragraph = new ArrayList<>();
        ArrayList<String> swc = new ArrayList<>();
        String s = "";
        int sentence = 0; paragraph.add(new ArrayList<String>());
        for (int j = 0; j < text.length(); j ++){
            if ((65 <= text.charAt(j) && text.charAt(j) <= 90)
                    || (97 <= text.charAt(j) && text.charAt(j) <= 122)
                    || (48 <= text.charAt(j) && text.charAt(j) <= 57) || text.charAt(j) == 45){
                s += text.charAt(j);
            }
            else{
                if (s != "") paragraph.get(sentence).add(s);
                s = "";
                if (text.charAt(j) == '?' || text.charAt(j) == '!' || text.charAt(j) == '.')
                { sentence ++; paragraph.add(new ArrayList<String>());}
            }
        }
        s = "";
        for (int i = 0; i < message.length(); i ++){
            if (message.charAt(i) != ' ') s += message.charAt(i);
            else {swc.add(s); System.out.println(s); s = ""; }
        }
        swc.add(s);
        s = ""; String s2 = "";
        for (int i = 0; i < swc.size(); i ++) {
            String[] arr = (swc.get(i)).split("\\.");
            for (int j = 0; j < arr.length; j++) System.out.println(arr[j] + " ");
            int row = Integer.parseInt(arr[0]), word = Integer.parseInt(arr[1]), letter = Integer.parseInt(arr[2]);
            if (row >= paragraph.size() || word > paragraph.get(row - 1).size() || letter > paragraph.get(row - 1).get(word - 1).length())
                s += " ";
            else s += paragraph.get(row - 1).get(word - 1).charAt(letter - 1);
        }
    }
}
