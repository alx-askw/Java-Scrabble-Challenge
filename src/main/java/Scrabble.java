import java.sql.Array;
import  java.util.HashMap;
import java.util.Map;

public class Scrabble {

    private String word;
    int scoreFigure;
    private String[] wordArray;

    public Scrabble(String args){
        this.word = args;
        this.scoreFigure = 0;
        this.wordArray = word.split("");
    }


    public Integer scoreValue(String letter) {
        HashMap<String, Integer> scoreMap = new HashMap<String, Integer>();
        scoreMap.put("A", 1);
        scoreMap.put("E", 1);
        scoreMap.put("I", 1);
        scoreMap.put("O", 1);
        scoreMap.put("U", 1);
        scoreMap.put("L", 1);
        scoreMap.put("N", 1);
        scoreMap.put("R", 1);
        scoreMap.put("S", 1);
        scoreMap.put("T", 1);
        scoreMap.put("D", 2);
        scoreMap.put("G", 2);
        scoreMap.put("B", 3);
        scoreMap.put("C", 3);
        scoreMap.put("M", 3);
        scoreMap.put("P", 3);
        scoreMap.put("F", 4);
        scoreMap.put("H", 4);
        scoreMap.put("V", 4);
        scoreMap.put("W", 4);
        scoreMap.put("Y", 4);
        scoreMap.put("K", 5);
        scoreMap.put("J", 8);
        scoreMap.put("X", 8);
        scoreMap.put("Q", 10);
        scoreMap.put("Z", 10);
        return scoreMap.get(letter);
    }

    private int scoreCalculator(){
        for(int i = 0; i < wordArray.length; i++){
            scoreFigure += scoreValue(wordArray[i]);
        }
        return scoreFigure;
    }

//    private void stringToArray(){
//        for(int i = 0; i < wordArray.length; i++){
//            wordArray[i] = scoreValue("a");
//        }
//    }

    public int score(){
        return scoreCalculator();
    }

    public static void main(String[] args) {
    }
}
