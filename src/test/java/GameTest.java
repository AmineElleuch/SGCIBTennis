import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    private Player playerOne;
    private Player playerTwo;
    private Game game;


    @Before
    //Given
    public void intialiseGame() {
        playerOne = new Player("Marion");
        playerTwo = new Player("John");
        game = new Game(playerOne, playerTwo);
    }

    @Test
    public void testGetScore() {
        //When
        playerOne.winBall();
        playerOne.winBall();
        playerOne.winBall();
        playerTwo.winBall();
        //Then
        assertEquals(game.getScore(), "forty fifteen");
    }

    @Test
    public void testDeuce() {
        //When
        playerOne.winBall();
        playerOne.winBall();
        playerOne.winBall();
        playerTwo.winBall();
        playerTwo.winBall();
        playerTwo.winBall();
        //Then
        assertEquals(game.getScore(), "deuce");
    }


    @Test
    public void testAdvantage() {
        //When
        playerOne.winBall();
        playerOne.winBall();
        playerOne.winBall();
        playerTwo.winBall();
        playerTwo.winBall();
        playerTwo.winBall();
        playerTwo.winBall();

        //Then
        assertEquals(game.getScore(), "Advantage for Marion");
    }

    @Test
    public void testWinGame() {
        //When
        for (int i = 0; i <= 3; i++) {
            game.winBall(playerOne);
        }
        //Then
        assertEquals(game.getScoreGame(), " Player John score Game :0 Player Marion score Game :1");
    }


    @Test
    public void testWinSet() {
        //When
        for (int i = 0; i <= 23; i++) {
            game.winBall(playerOne);
        }
        //Then
        assertEquals(game.getScoreSet(), " Player John score Set: 0 Player Marion score Set: 1");
    }

    @Test
    public void testWinMatch() {
        //When
        for (int i = 0; i <= 31; i++) {
            game.winBall(playerOne);
            //Then
        }
        assertEquals(game.isWinnerFinal(playerOne.getName()), "Marion");
    }

    @Test
    public void testNoOneHasWonMatchYet() {
        //When
        for (int i = 0; i <= 29; i++) {
            game.winBall(playerOne);
            //Then
        }
        assertEquals(game.isWinnerFinal(playerOne.getName()),"");
    }


    @Test
    public void testTieBreak() {
        //When
        for (int i = 0; i <= 22; i++) {
            game.winBall(playerOne);
        }
        for (int i = 0; i <= 22; i++) {
            game.winBall(playerTwo);
        }
        assertEquals(game.getTiebreak(), 7);
    }

}
