import java.util.ArrayList;
import java.util.HashMap;

/**
 * track score and player id for a single player of a game
 */

public class GameRecord implements Comparable<GameRecord>{
    private int score;
    private int numbers;

    private String playerId;


    @Override
    public String toString() {
        return super.toString();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNumbers(){
        return numbers;
    }

    public String getPlayerId(){
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    /**
     * compare scores
     * @param other the object to be compared.
     * @return
     */
    @Override
    public int compareTo(GameRecord other){
        if(this.score > other.score){
            return 1;
        } else if(this.score < other.score){
            return -1;
        }else{
            return 0;
        }
    }

}