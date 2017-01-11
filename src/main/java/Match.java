import java.util.HashMap;
import java.util.Map;

public class Match {

    protected Player playerOne;
    protected Player playerTwo;

    protected HashMap<String, Integer> scoreSet = new HashMap<String, Integer>();

    public Match(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        scoreSet.put(playerOne.getName(), playerOne.getScore());
        scoreSet.put(playerTwo.getName(), playerTwo.getScore());
    }

    public void incrementScoreSet(String player) {
        scoreSet.put(player, scoreSet.get(player) + 1);
    }

    public String isWinnerFinal(String player) {
        String result ="";
        if (scoreSet.get(player) == 2) {
            System.out.println(player + " Won the Match");
            result = player;
        }
        return result;
    }

    public String getScoreSet() {
        String result ="";
        for (Map.Entry<String, Integer> entry : scoreSet.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            result += (" Player " + entry.getKey() + " score Set: " + entry.getValue());
        }
        return result;
    }


}
