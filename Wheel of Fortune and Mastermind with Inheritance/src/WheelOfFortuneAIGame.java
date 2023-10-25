import java.util.ArrayList;

/**
 * For each AI player specified, this class will play a game for each phrase read in from the file.
 * So if there are m players and n phrases, Game’s playAll() should play m*n games.
 */
public class WheelOfFortuneAIGame extends WheelOfFortune implements WheelOfFortunePlayer{
    WheelOfFortunePlayer player;
    ArrayList<WheelOfFortunePlayer> players;

    /**
     *  have three constructors.
     * One should set the WheelOfFortunePlayer to a default player,
     */
    public WheelOfFortuneAIGame(){
    }

    /**
     *
     * one should allow the client to specify a single concrete WheelOfFortunePlayer,
     */
    public WheelOfFortuneAIGame(WheelOfFortunePlayer singlePlayer){
        this.player = player;
    }

    /**
     *
     * and one should accept a list of WheellOfFortunePlayers.
     */
    public WheelOfFortuneAIGame(ArrayList<WheelOfFortunePlayer> players){
        this.players = new ArrayList<WheelOfFortunePlayer>();
    }

    public AllGamesRecord playAll(){

        return null;
    }

    @Override
    public GameRecord play() {
        return null;
    }

    @Override
    public boolean playNext() {
        return false;
    }

    @Override
    public char getGuess(String previousGuesses) {
        return 0;
    }

    @Override
    public char nextGuess() {
        return 0;
    }

    @Override
    public String playerId() {
        return null;
    }

    @Override
    public void reset() {

    }


    /**
     * WheelOfFortunedAIGame should create at least three different players,
     * then call playAll() to run through all the phrases for each player.
     * Both main’s should demonstrate the methods of GamesRecord to display results.
     */
    public static void main(String [] args) {
        WheelOfFortuneAIGame hangmanUserGame = new WheelOfFortuneAIGame();
        AllGamesRecord record = hangmanUserGame.playAll();
        System.out.println(record);  // or call specific functions of record
    }

}
