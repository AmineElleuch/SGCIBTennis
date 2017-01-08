import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    private Player playerOne;
    private Player playerTwo;
    private Set set;

    @Before
    //Given
    public void intialiseGame() {
        playerOne = new Player("John");
        playerTwo = new Player("Marion");
        set = new Set(playerOne, playerTwo);
    }

    @Test
    public void testGetScore(){
        //When
        playerOne.winBall();
        playerOne.winBall();
        playerOne.winBall();
        playerTwo.winBall();
        //Then
        assertEquals(set.getScore(),"Forty Fifty");
    }
    @Test
    public void testDeuce(){
        //When
        playerOne.winBall();
        playerOne.winBall();
        playerOne.winBall();
        playerTwo.winBall();
        playerTwo.winBall();
        playerTwo.winBall();
        //Then
        assertEquals(set.getScore(),"deuce");
    }
    @Test
    public void testTieBreak(){
        //When
        playerOne.winBall();
        playerOne.winBall();
        playerOne.winBall();
        playerOne.winBall();
        playerTwo.winBall();
        playerTwo.winBall();
        playerTwo.winBall();
        playerTwo.winBall();
        //Then
        assertEquals(set.getScore(),"deuce");
    }


    @Test
    public void testAdvantage(){
        //When
        playerOne.winBall();
        playerOne.winBall();
        playerOne.winBall();
        playerTwo.winBall();
        playerTwo.winBall();
        playerTwo.winBall();
        playerTwo.winBall();

        //Then
        assertEquals(set.getScore(),"Advantage for Marion");
    }

    @Test
    public void testWinner(){
        //When
        playerOne.winBall();
        playerOne.winBall();
        playerOne.winBall();
        playerOne.winBall();
        //Then
        assertEquals(set.getScore(),"John won");
    }


}
