import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 */

public abstract class WheelOfFortune extends Game {

    public String phrase;
    public StringBuilder hiddenPhrase;
    public String previousGuesses;

    public int phraseListSize;

    public ArrayList<Integer> indexOfPhrase;

    public int numbersPlayed;


    public WheelOfFortune() {
        this.phrase = "";
        this.previousGuesses = "";
        this.indexOfPhrase=new ArrayList<>();
        numbersPlayed = 0;
    }

    /**
     * readPhrases
     */

    /**
     * Choose a random phrase from a given list.
     * put that code into a method that reads the phrases() from the file and returns an arrayList of Strings.
     * The idea is now you'll loop through and play all()phrases and keep score.
     */
    public void readPhrases() {
        List<String> phraseList = null;
        // Get the phrase from a file of phrases
        try {
            phraseList = Files.readAllLines(Paths.get("Wheel of Fortune and Mastermind with Inheritance/phrases.txt"));
        } catch (IOException e) {
            System.out.println(e);
        }


        // Get a random phrase from the list
        randomPhrase(phraseList);
    }

    /**
     * get random phrase
     */
    public void randomPhrase(List<String> phraseList) {

        // Get a random phrase from the list
        Random rand = new Random();
        phraseListSize=phraseList.size();
        int r = rand.nextInt(phraseListSize); // gets 0, 1, or 2//link to file or something
        this.phrase = phraseList.get(r);
    }


    /**
     * getHiddenPhrase
     */
    /**
     * Generate the initial hidden phrase chosen from the list.
     */
    public void getHiddenPhrase(){
        this.hiddenPhrase = new StringBuilder(phrase);
        //show the hidden phrases with *
        for(int i=0; i<phrase.length(); i++){
            if(Character.isLetter(phrase.charAt(i))) {
                hiddenPhrase.setCharAt(i, '*');
            }
        }
        //print the hidden phrase
        System.out.println(hiddenPhrase);
    }

    /**
     * processGuess
     */
    /**
     * Judge whether a letter matches any letter inside the chosen phrase,
     * and modifies the partially hidden phrase if there is a match.
     *
     * @param  phrase original chosen phrase
     * @param  letterInput letter which was entered by player
     * @return matching result (true or false)
     */
    public boolean processGuess(String phrase, char letterInput) {
        StringBuilder originalPhrase = new StringBuilder(phrase);
        //change all letters to small characters.
        String lowercasePhrase = phrase.toLowerCase();

        char lowercaseLetterInput = Character.toLowerCase(letterInput);
        //declare a boolean variable to store the result and initialize with false
        boolean matchResult = false;

        //if the guessed letter is not included in the phrase, set the match result as false.
        if (lowercasePhrase.indexOf(lowercaseLetterInput) == -1) {
            System.out.println("This letter is not in the phrase. You lost 1 chance.");
            matchResult = false;
        } else {
            //when the input letter is new and correct, check the phrase and replace * where matches and set the match result as true
            char ch;
            for (int i = 0; i < phrase.length(); i++) {

                ch = lowercasePhrase.charAt(i);

                //check if the element looking at is a letter
                if (Character.isLetter(ch)) {
                    //check if the guessed letter is right, if so, replace * with the original letter
                    if (ch == lowercaseLetterInput) {
                        (this.hiddenPhrase).setCharAt(i, originalPhrase.charAt(i));
                    }
                }
            }
            matchResult = true;
        }

        //add the guessed letter to previously guesses
        previousGuesses += lowercaseLetterInput;
        return matchResult;
    }

    /**
     * which returns a char, thus requiring all concrete WheelOfFortune games to implement it.
     */
    public abstract char getGuess(String previousGuesses);


}
