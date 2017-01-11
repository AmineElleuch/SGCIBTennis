import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Set extends Match {

    protected HashMap<String, Integer> scoreGame = new HashMap<String, Integer>();
    private int tiebreak = 6;

    public int getTiebreak() {
        return tiebreak;
    }

    public Set(Player playerOne, Player PlayerTwo) {
        super(playerOne, PlayerTwo);
        scoreGame.put(playerOne.getName(), playerOne.getScore());
        scoreGame.put(playerTwo.getName(), playerTwo.getScore());
    }

    public void intialiseScoreGame() {
        scoreGame.put(playerOne.getName(), playerOne.getScore());
        scoreGame.put(playerTwo.getName(), playerTwo.getScore());
    }

    public String getScoreGame() {
        String result ="";
        for (Map.Entry<String, Integer> entry : scoreGame.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            result += (" Player " + entry.getKey() + " score Game :" + entry.getValue());
        }
        return result;
    }

    public void incrementScoreGame(String player) {
        scoreGame.put(player, scoreGame.get(player) + 1);
        if (isWinnerSet(player)) {
            super.incrementScoreSet(player);
            System.out.println(player + " is the winner of this set with " + scoreGame.get(player) + " games");
            try {
                super.isWinnerFinal(player);
            }
            catch (EndMatchException e){
                System.exit(1);};
            this.intialiseScoreGame();
        }
    }

    public boolean isWinnerSet(String player) {
        ArrayList<Integer> values = new ArrayList<Integer>();
        for (int i : scoreGame.values()) {
            values.add(i);
        }
        if ((values.get(0) >= 5 && values.get(1) >= 5)) {
            if (values.get(0).equals(values.get(1))) {
                tiebreak = tiebreak + 1;
            }
        }
        if (scoreGame.get(player) == tiebreak) {
            tiebreak = 6;
            return true;
        }
        return false;
    }


}
