import java.util.HashMap;

public class Set {

    private Player playerOne;
    private Player playerTwo;
    private static HashMap<Integer, String> ruleScore = new HashMap<Integer, String>();

    static {
        ruleScore.put(0, "zero");
        ruleScore.put(1, "fifteen");
        ruleScore.put(2, "Thirty");
        ruleScore.put(3, "forty");
    }

    public Set(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public String getScore() {
        if (playerOne.getScore() >= 3 && playerTwo.getScore() >= 3) {
            if (playerOne.getScore() == playerTwo.getScore()) {
                return "deuce";
            } else if (Math.abs(playerOne.getScore() - playerTwo.getScore()) >= 2) {
                return getLeader() + " won";
            } else {
                return "Advantage for " + getLeader();
            }
        } else {
            if ((playerOne.getScore() > 3 && playerTwo.getScore() < 3) || (playerOne.getScore() < 3 && playerTwo.getScore() > 3)) {
                return getLeader() + " won";
            } else {
                return ruleScore.get(playerOne.getScore()) + " " + ruleScore.get(playerTwo.getScore());
            }

        }
    }

    public String getLeader() {
        return playerOne.getScore() > playerTwo.getScore() ? playerOne.getName() : playerTwo.getName();
    }

}
