import java.util.HashMap;

public final class Game extends Set {

    private static HashMap<Integer, String> ruleScore = new HashMap<Integer, String>();

    static {
        ruleScore.put(0, "zero");
        ruleScore.put(1, "fifteen");
        ruleScore.put(2, "Thirty");
        ruleScore.put(3, "forty");
    }

    public Game(Player playerOne, Player playerTwo) {
        super(playerOne, playerTwo);
    }

    public void intialiseScorePlayers() {
        this.playerOne.setScore(0);
        this.playerTwo.setScore(0);
    }


    public String getScore() {
        if (playerOne.getScore() >= 3 && playerTwo.getScore() >= 3) {
            if (playerOne.getScore() == playerTwo.getScore()) {
                return "deuce";
                //changer pas is winner
            } else if (Math.abs(playerOne.getScore() - playerTwo.getScore()) >= 2) {
                return getLeader().getName() + " won the game";
            } else {
                return "Advantage for " + getLeader().getName();
            }
        } else {
            //changer pas is winner
            if ((playerOne.getScore() > 3 && playerTwo.getScore() < 3) || (playerOne.getScore() < 3 && playerTwo.getScore() > 3)) {
                return getLeader().getName() + " won the game";
            } else {
                return ruleScore.get(playerOne.getScore()) + " " + ruleScore.get(playerTwo.getScore());
            }

        }
    }

    public Player getLeader() {
        return playerOne.getScore() > playerTwo.getScore() ? playerOne : playerTwo;
    }

    public void winBall(Player player) {
        if (player.equals(playerOne)) {
            System.out.println(getScore());
            playerOne.winBall();
            if (playerOne.equals(isWinnerGame())) {
                System.out.println(getScore());
                super.incrementScoreGame(playerOne.getName());
                this.intialiseScorePlayers();
            }
        } else {
            System.out.println(getScore());
            playerTwo.winBall();
            System.out.println(getScore());
            if (playerTwo.equals(isWinnerGame())) {
                System.out.println(getScore());
                super.incrementScoreGame(playerTwo.getName());
                this.intialiseScorePlayers();
            }
        }
    }

    public Player isWinnerGame() {
        if (playerOne.getScore() >= 3 && playerTwo.getScore() >= 3 && Math.abs(playerOne.getScore() - playerTwo.getScore()) >= 2) {
            return getLeader();
        }
        if ((playerOne.getScore() > 3 && playerTwo.getScore() < 3) || (playerOne.getScore() < 3 && playerTwo.getScore() > 3)) {
            return getLeader();
        }
        return null;
    }

}
