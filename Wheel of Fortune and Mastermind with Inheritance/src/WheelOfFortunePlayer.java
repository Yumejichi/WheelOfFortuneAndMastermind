/**
 * This interface define methods needed by all WheelOfFortunePlayers:
 */

public interface WheelOfFortunePlayer {
    /**
     * get the next guess from the player
     * @return next gues
     */
    public char nextGuess();

    /**
     * set an id for the player
     * @return an id for the player
     */
    public String playerId();

    /**
     *  reset the player to start a new game
     */
    public void reset();
}
