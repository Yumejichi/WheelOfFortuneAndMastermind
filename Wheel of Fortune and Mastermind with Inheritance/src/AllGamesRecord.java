import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * record all the scores for each play for all games(all users)
 */

public class AllGamesRecord{

    List<GameRecord> allScores;

    /**
     * adds a GameRecord to the AllGamesRecord
     */
    public void add(GameRecord gameRecord){
        this.allScores.add(gameRecord);
    }

    /**
     * returns the average score for all games added to the record
     */
    public float average(){
        float average = 0.0f;
        int sum = 0;
        for(int i=0; i<this.allScores.size(); i++){
            sum += this.allScores.get(i).getScore();
        }
        average = (float)sum/(float)this.allScores.size();
        return average;
    }

    /**
     * returns the average score for all games of a particular player
     */
    public float average(int playerId){
        float average = 0.0f;
        int sum = 0;
        for(int i=0; i<this.allScores.size(); i++){
            if(this.allScores.get(i).getPlayerId().equals(playerId)){
                sum = sum + this.allScores.get(i).getScore();
            }
        }
        average = (float)sum/(float)this.allScores.size();
        return average;
    }


    /**
     *
     * - highGameList(n)-- returns a sorted list of the top n scores including player and score.
     * This method should use the Collections class to sort the game instances.
     */

    public List<GameRecord> highGameList(int n){

        List<GameRecord> sortedListOfTopScores = new ArrayList<GameRecord>();
        Collections.sort(allScores);

        //add highest n values to the new list
        for(int i=0; i<n; i++){
            sortedListOfTopScores.add(allScores.get(i));
        }
        return sortedListOfTopScores;
    }


    /**
     *
     * - highGameList(playerId, n)-- returns a sorted list of the top n scores for the specified player..
     * This method should use the Collections class to sort the game instances.
     */
    public List<GameRecord> highGameList(String playerId, int n){
        //create a list to store all scores for a specified player
        List<GameRecord> allScoresOfAPlayer = new ArrayList<>();
        //create an array list to store the top n scores for the specified player
        List<GameRecord> sortedListOfTopScoresOfAPlayer = new ArrayList<>();

        //get the list for all scores for a specific player
        for(int i=0; i<this.allScores.size(); i++){
            if(this.allScores.get(i).getPlayerId().equals(playerId)){
                allScoresOfAPlayer.add(allScores.get(i));
            }
        }

        Collections.sort(allScoresOfAPlayer);


        //add highest n values to the new list
        for(int i=0; i<n; i++){
            sortedListOfTopScoresOfAPlayer.add(allScores.get(i));
        }
        return sortedListOfTopScoresOfAPlayer;
    }


}
