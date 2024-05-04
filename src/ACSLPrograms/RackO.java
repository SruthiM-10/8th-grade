package ACSLPrograms;
import java.util.*;

public class RackO {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String info = scan.nextLine(), rack = scan.nextLine(), pile = scan.nextLine();
        String[] arr = info.split(" ");
        int slots = Integer.parseInt(arr[0]), num = Integer.parseInt(arr[1]);
        arr = rack.split(" ");
        int[] cards = new int[slots];
        for (int i = 0; i < slots; i ++) {
            cards[i] = Integer.parseInt(arr[i]);
        }
        int[] sortedCards = cards.clone();
        Arrays.sort(sortedCards);
        String[] drawpile = pile.split(" ");

        int cardnum = 0;
        boolean flag;
        while (!Arrays.equals(cards, sortedCards) && cardnum < drawpile.length){
            int card = Integer.parseInt(drawpile[cardnum]);
            flag = false;
            //rule 1
            for (int i = 1; i < slots; i ++){
                if (card == (cards[i] - 1)){
                    cards[i - 1] = card;
                    flag = true; break;
                }
            }
            //rule 2
            if (!flag){
                for (int i = 0; i < slots - 1; i ++){
                    if (card == (cards[i] + 1)){
                        cards[i + 1] = card;
                        flag = true; break;
                    }
                }
            }
            //rule 3
            if (!flag){
                for (int i = 2; i < slots; i ++){
                    if (!(cards[i - 1] < cards[i] && cards[i - 1] > cards[i - 2])){
                        if (card < cards[i] && card > cards[i - 2]){
                            cards[i - 1] = card;
                            flag = true; break;
                        }
                    }
                }
            }
            //rule 4
            if (!flag){
                if (card < cards[1] && cards[0] > cards[1]){
                    cards[0] = card;
                    flag = true;
                }
            }
            //rule 5
            if (!flag){
                if (card > cards[slots - 2] && cards[slots - 1] < cards[slots - 2]){
                    cards [slots - 1] = card;
                }
            }
            cardnum ++;
            sortedCards = cards.clone();
            Arrays.sort(sortedCards);
        }
        int value = 0, sequenceVal = 0;
        if (Arrays.equals(cards, sortedCards)){
            value = cards[0];
            for (int i = 1; i < slots; i ++){
                value += cards[i];
                if (cards[i - 1] + 1 == cards[i]) sequenceVal += 5;
                else if (sequenceVal >= 10){
                    value += sequenceVal + 5;
                    sequenceVal = 0;
                }
                else sequenceVal = 0;

            }
            if (sequenceVal >= 10) value += sequenceVal + 5;
        }
        else{
            for (int i = 0; i < slots - 1; i ++){
                if (cards[i + 1] < cards[i]) value --;
            }
        }
        System.out.println(value);
    }
}
