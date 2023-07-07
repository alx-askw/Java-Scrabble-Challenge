import  java.util.HashMap;

public class Scrabble {

    //dislike the amount of properties / could some be static?
    private String word;
    int scoreFigure;
    private String[] wordArray;
    private boolean isDoubleWord; //primitive default = false
    private boolean isTripleWord;
    private Character[] doubleLetters;
    private Character[] tripleLetters;
    private int wordMultiplier; //this is to cut down on lines in methods

    //I don't really like these conditionals in the constructor
    public Scrabble(String args){
        if(args != null){
            this.word = args.toUpperCase();
            this.wordArray = strToArray(this.word);
        }
        if(args == null){
            this.wordArray = new String[]{""};
        }
        this.scoreFigure = 0;
        this.wordMultiplier = 1;
        this.doubleLetters = new Character[0]; //need to default these to something due to how score is worked out in
        this.tripleLetters = new Character[0]; //less than 5 lines

    }

    //Extended test 1 - 2 constructor (both are over 5 lines but not methods per se)
    public Scrabble(String args, Character[] char1, Character[] char2, boolean isDouble, boolean isTriple){
        if(args != null){
            this.word = args.toUpperCase();
            this.wordArray = strToArray(this.word);
        }
        if(args == null){
            this.wordArray = new String[]{""};
        }
        this.scoreFigure = 0;
        this.isDoubleWord = isDouble;
        this.isTripleWord = isTriple;
        this.wordMultiplier = wordMulti();
        this.doubleLetters = charArrayIsNull(char1);
        this.tripleLetters = char2;
    }


    private int wordMulti() {
        if (this.isDoubleWord || this.isTripleWord) {
            return (this.isDoubleWord && !this.isTripleWord) ? 2 : 3;
        }
        return 1;
    }

    private String[] strToArray(String word){
        if(word != null){
            return word.split("");
            }
        return new String[] {""};
    }

    private Character[] charArrayIsNull(Character[] args){
        if (args != null){
            return args;
        }
        return new Character[1];
    }

    //only function (not including constructors) that's over 5 lines (out of necessity)
    //notes for later me + reader - could these have been done elsewhere/better approach
    public int scoreValue(String letter) {
        HashMap<String, Integer> scoreMap = new HashMap<>();
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
        return scoreMap.getOrDefault(letter, 0); //avoid an exception here?
    }

    private int letterDoubler() {
        int returnValue = 0;
        for (int i = 0; i < this.doubleLetters.length; i++) {
            returnValue += scoreValue(doubleLetters[i].toString());
        }
        return returnValue;
    }
    //these two could probably been mashed together - on the tip of my mind but can't quite figure it out
    private int letterTripler() {
        int returnValue = 0;
        for (int i = 0; i < this.tripleLetters.length; i++) {
            returnValue += scoreValue(tripleLetters[i].toString());
        }
        return returnValue*2;
    }

    private int scoreCalculator(){
        for(int i = 0; i < wordArray.length; i++){
            this.scoreFigure += scoreValue(wordArray[i]);
        }
        return this.scoreFigure;
    }

    public int score(){
        if(this.wordArray.length < 1){
            return 0;
        }
        return ((scoreCalculator() + letterDoubler() + letterTripler())*this.wordMultiplier);
    }
}
