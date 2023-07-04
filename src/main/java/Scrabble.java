import java.util.Arrays;
import  java.util.HashMap;


public class Scrabble {

    private String word;
    int scoreFigure;
    private String[] wordArray;

    public Scrabble(String args){
        this.word = args;
        this.scoreFigure = 0;
        this.wordArray = strToArray(this.word);
    }

    private String[] strToArray(String word){
        try {
            return this.wordArray = word.split("");
        } catch (NullPointerException e) {
            return this.wordArray = new String[]{""};
        }
    }

    public int scoreValue(String letter) {
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
        return scoreMap.getOrDefault(letter, 0);
    }

    private int scoreCalculator(){
        for(int i = 0; i < wordArray.length; i++){
            this.scoreFigure += scoreValue(wordArray[i]);
        }
        return this.scoreFigure;
    }

//    private void stringToArray(){
//        for(int i = 0; i < wordArray.length; i++){
//            wordArray[i] = scoreValue("a");
//        }
//    }

    public int score(){
        if(this.wordArray[0].equals("")){
            return 0;
        }
        return scoreCalculator();
    }

    public void printArray(){
        System.out.println(Arrays.toString(this.wordArray));
    }

    public static void main(String[] args) {
        Scrabble testing = new Scrabble("a");
        testing.printArray();
        testing.score();
        System.out.println(testing.score());
    }
}
