import java.util.Scanner;

/**
 * WheelOfFortuneUserGame should allow the user to play each game with a random phrase,
 * and if there are more phrases, ask after the game if the player wants to continue.
 * Once a particular phrase is used, it should be discarded from the phrase list so it isn’t chosen again.
 * The class should implement the play() and playNext() methods from Game in order to make these things happen.
 */

public class WheelOfFortuneUserGame extends WheelOfFortune implements WheelOfFortunePlayer{


    @Override
    public AllGamesRecord playAll() {
        AllGamesRecord allRecords = new AllGamesRecord();
        boolean gameIsValid = true;
        //plays a set of games
        while(gameIsValid){
            //get if to play the next game
            boolean playNext = playNext();
            GameRecord record = play();
            allRecords.add(record);

            //stop when the user requires or all the phrases are played
            if(!playNext){
                gameIsValid = false;
            }
        }

        return allRecords;
    }

    @Override
    public GameRecord play() {
        GameRecord record = new GameRecord();

        record.setPlayerId(playerId());



        //get a random phrase
        readPhrases();

        //decide the chances and record how many misses
        int chance = (phrase.length())/2;
        if(chance>10){
            chance = 10;
        }
        int miss = 0;

        //display the instructions
        instruction(chance);


        //replace the phrase with *(get the hiddenphrase)
        getHiddenPhrase();

        // define a boolean to record if to continue to guess
        boolean continueGuess = true;

        //loop while the player has more than 0 chances
        while(continueGuess) {

            //declare a boolean variable to store the result and initialize with false
            boolean matchResult = false;

            //get the input letter and convert it to a lowercase letter to use in the following judgement
            //get user guess
            char letterInput = getGuess(previousGuesses);

            //confirm if a letter matches and modify the hidden phrase
            matchResult = processGuess(phrase, letterInput);

            //count misses / remain chances and record the score

            if (matchResult == false) {
                chance--;
                miss++;
            }


            //show the result

            //print out the hidden phrase with correctly guessed letters and the times of misses and left chances.
            System.out.println("The phrase with correctly guessed letters: " + hiddenPhrase);
            System.out.println("All letters guessed before: " + previousGuesses);
            System.out.println("Status: Miss: " + miss + ", Left chance: " + chance);
            System.out.println();


            //if all letters are guessed, finish the game
            if (hiddenPhrase.indexOf("*") == -1) {
                System.out.println("\nCongratulations! You have successfully guessed all letters!");
                continueGuess=false;
            }

            //if the player run out all the chances, finish the game
            if (chance == 0) {
                System.out.println("\nI am sorry, you have ran out all of the chances. Try next time.");
                continueGuess=false;
            }
            //before ending the play, set records
            //set score as chance - miss
            record.setScore(chance - miss);

        }




        return null;
    }

    @Override
    public boolean playNext() {
        //if the player wants to end the game then finish
        Scanner scanner = new Scanner(System.in);
        if(numbersPlayed>1) {
            System.out.println("Do you want to continue playing? enter y to continue, enter n to end the game");
            String userAnswer = scanner.nextLine();
            if(userAnswer.equals("n")){
                return false;
            }
        }

        //if all phrases are chosen, then finish
        if(numbersPlayed>=phraseListSize){
            return false;
        }

        return true;
    }

    @Override
    public char getGuess(String previousGuesses) {
        char letterInput;

        while(true) {
            System.out.println("Guess and enter a letter: ");
            Scanner scanner = new Scanner(System.in);
            String playerInput = scanner.nextLine();

            //If the player enters nothing, let the player enter again
            if(playerInput.length() == 0){
                System.out.println("You entered nothing.");
                System.out.println("The phrase with correctly guessed letters: " + hiddenPhrase);
                continue;
            }

            //store the first letter entered as player input
            char input = playerInput.charAt(0);

            //if a letter is already guessed, do not count and let the player try again.
            if (previousGuesses.indexOf(input) != -1) {
                System.out.println("You have guessed this letter before. Try another one.");
                System.out.println("The phrase with correctly guessed letters: " + hiddenPhrase);
                continue;
            }

            //if the input is not a letter, let the player enter again
            if (!Character.isLetter(input)) {
                System.out.println("This is not a letter. Please enter a letter.");
                System.out.println("The phrase with correctly guessed letters: " + hiddenPhrase);
            }else{
                letterInput = input;
                break;
            }
        }
        return letterInput;
    }

    @Override
    public char nextGuess() {
        return 0;
    }

    @Override
    public String playerId() {
        String plyerId = "";

        //if the player is a user, let the player input an id
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an id for play");
        plyerId = scanner.nextLine();

        return plyerId;
    }

    @Override
    public void reset() {

    }

    @Override
    public String toString() {
        return "WheelOfFortuneUserGame{" +
                "phrase='" + phrase + '\'' +
                ", hiddenPhrase=" + hiddenPhrase +
                ", previousGuesses='" + previousGuesses + '\'' +
                ", phraseListSize=" + phraseListSize +
                ", indexOfPhrase=" + indexOfPhrase +
                ", numbersPlayed=" + numbersPlayed +
                ", records=" + records +
                '}';
    }



    public void instruction(int chance){
        //show instructions
        System.out.println("---------------------------------How to play---------------------------------");
        System.out.println("Please guess letters in the below hidden phrase.(Shorter phrase has less chances)");


        //show instructions of how to play
        System.out.println("You will have " + chance + " chances to guess what letters are in the phrase.");
        System.out.println("You will see the phrase with new guessed letter once you enter the correct letter.");
        System.out.println("You will not see the change in the phrase when you enter a wrong letter.");
        System.out.println("When you guess a wrong letter, your will lose one chance.");
        System.out.println("When you guess the same letter you missed before, you will not lose a chance.");
        System.out.println("If you enter more than one letter, only the first letter will be considered.");
        System.out.println("Let's start!");
        System.out.println("-----------------------------------------------------------------------------");

    }





    /**
     * main method
     * WheelOfFortunedUserGame should allow the user to play until they quit or run out of phrases.
     * Both main’s should demonstrate the methods of GamesRecord to display results.
     */

    public static void main(String [] args) {
        WheelOfFortuneUserGame hangmanUserGame = new WheelOfFortuneUserGame();
        AllGamesRecord record = hangmanUserGame.playAll();
        System.out.println(record);  // or call specific functions of record

        //display highGameList(for two games?)

        //display average of games



    }

}
