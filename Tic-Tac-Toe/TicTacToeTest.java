import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TicTacToeTest {

    @SuppressWarnings("unused")
    private TicTacToe game;

    public TicTacToeTest() {
        
    }
@Before
    public void setUp(){
        @SuppressWarnings("unused")
        TicTacToe game = new TicTacToe (); 
    }

@Test
    public void testInitialBoardState() {
        TicTacToe game = new TicTacToe();
        char[][] board = game.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals('-', board[i][j]);
            }
        }
    }
@Test 
public void testPlayerMove(){
    TicTacToe game = new TicTacToe();
    game.placeMark(0, 0);
        assertEquals('X', game.getBoard()[0][0]);
    }
    @Test
    public void testInvalidMove() {
        TicTacToe game = new TicTacToe();
        game.placeMark(0, 0);
        assertFalse(game.placeMark(0, 0));
    }

    @Test
    public void testWinningConditionRow() {
        TicTacToe game = new TicTacToe();
        game.placeMark(0, 0);
        game.placeMark(0, 1);
        game.placeMark(0, 2);
        assertTrue(game.checkForWin());
    }

    @Test
    public void testWinningConditionColumn() {
        TicTacToe game = new TicTacToe();
        game.placeMark(0, 0);
        game.placeMark(1, 0);
        game.placeMark(2, 0);
        assertTrue(game.checkForWin());
    }

    @Test
    public void testWinningConditionDiagonal() {
        TicTacToe game = new TicTacToe();
        game.placeMark(0, 0);
        game.placeMark(1, 1);
        game.placeMark(2, 2);
        assertTrue(game.checkForWin());
    }

    @Test
    public void testDrawCondition() {
        TicTacToe game = new TicTacToe();
        game.placeMark(0, 0);
        game.placeMark(0, 1);
        game.placeMark(0, 2);
        game.placeMark(1, 0);
        game.placeMark(1, 1);
        game.placeMark(1, 2);
        game.placeMark(2, 0);
        game.placeMark(2, 1);
        game.placeMark(2, 2);
        assertTrue(game.isDraw());
    }

    @Test
    public void testGameReset() {
        TicTacToe game = new TicTacToe();
        game.placeMark(0, 0);
        game.initializeBoard();
        char[][] board = game.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals('-', board[i][j]);
            }
        }
    }

    @Test
    public void testPlayerSwitching() {
        TicTacToe game = new TicTacToe();
        game.placeMark(0, 0);
        assertEquals('O', game.getCurrentPlayer());
        game.placeMark(1, 1);
        assertEquals('X', game.getCurrentPlayer());
    }

    @Test
    public void testWinningConditionAntiDiagonal() {
        TicTacToe game = new TicTacToe();
        game.placeMark(0, 2);
        game.placeMark(1, 1);
        game.placeMark(2, 0);
        assertTrue(game.checkForWin());
    }

    @Test
    public void testInvalidMoveOutOfBounds() {
        TicTacToe game = new TicTacToe();
        assertFalse(game.placeMark(3, 3));
    }

    @Test
    public void testWinningConditionNotMet() {
        TicTacToe game = new TicTacToe();
        game.placeMark(0, 0);
        game.placeMark(0, 1);
        assertFalse(game.checkForWin());
    }

    @Test
    public void testGameNotOverInitially() {
        TicTacToe game = new TicTacToe();
        assertFalse(game.isGameOver());
    }

    @Test
    public void testGameOverAfterWin() {
        TicTacToe game = new TicTacToe();
        game.placeMark(0, 0);
        game.placeMark(0, 1);
        game.placeMark(0, 2);
        assertTrue(game.isGameOver());
    }

    @Test
    public void testGameOverAfterDraw() {
        TicTacToe game = new TicTacToe();
        game.placeMark(0, 0);
        game.placeMark(0, 1);
        game.placeMark(0, 2);
        game.placeMark(1, 0);
        game.placeMark(1, 1);
        game.placeMark(1, 2);
        game.placeMark(2, 0);
        game.placeMark(2, 1);
        game.placeMark(2, 2);
        assertTrue(game.isGameOver());
    }

    @Test
    public void testPlayerCannotOverwriteMove() {
        TicTacToe game = new TicTacToe();
        game.placeMark(0, 0);
        assertFalse(game.placeMark(0, 0));
    }

    @Test
    public void testPlayerCannotMoveOutsideBoard() {
        TicTacToe game = new TicTacToe();
        assertFalse(game.placeMark(-1, 0));
        assertFalse(game.placeMark(0, -1));
        assertFalse(game.placeMark(3, 0));
        assertFalse(game.placeMark(0, 3));
    }

    @Test
    public void testPlayerCannotMoveAfterGameOver() {
        TicTacToe game = new TicTacToe();
        game.placeMark(0, 0);
        game.placeMark(0, 1);
        game.placeMark(0, 2);
        assertFalse(game.placeMark(1, 0));
    }

    @Test
    public void testSwitchPlayerAfterMove() {
        TicTacToe game = new TicTacToe();
        game.placeMark(0, 0);
        assertEquals('O', game.getCurrentPlayer());
        game.placeMark(1, 1);
        assertEquals('X', game.getCurrentPlayer());
    }

    @Test
    public void testGetCurrentPlayer() {
        TicTacToe game = new TicTacToe();
        assertEquals('X', game.getCurrentPlayer());
        game.placeMark(0, 0);
        assertEquals('O', game.getCurrentPlayer());
    }

    @Test
    public void testGameInitialization() {
        TicTacToe game = new TicTacToe();
        assertNotNull(game.getBoard());
        assertEquals('X', game.getCurrentPlayer());
    }

    @Test
    public void testGameOverAfterPlayerWins() {
        TicTacToe game = new TicTacToe();
        game.placeMark(0, 0);
        game.placeMark(0, 1);
        game.placeMark(0, 2);
        assertTrue(game.isGameOver());
    }

    @Test
    public void testBoardFullButNoWinner() {
        TicTacToe game = new TicTacToe();
        game.placeMark(0, 0);
        game.placeMark(0, 1);
        game.placeMark(0, 2);
        game.placeMark(1, 0);
        game.placeMark(1, 1);
        game.placeMark(1, 2);
        game.placeMark(2, 0);
        game.placeMark(2, 1);
        game.placeMark(2, 2);
        assertTrue(game.isDraw());
        assertTrue(game.isGameOver());
    }

    @Test
    public void testMoveUpdatesBoardCorrectly() {
        TicTacToe game = new TicTacToe();
        game.placeMark(0, 0);
        assertEquals('X', game.getBoard()[0][0]);
    }

    @Test
    public void testGameNotOverAfterReset() {
        TicTacToe game = new TicTacToe();
        game.placeMark(0, 0);
        game.initializeBoard();
        assertFalse(game.isGameOver());
    }

    @Test
    public void testGetBoardAfterReset() {
        TicTacToe game = new TicTacToe();
        game.placeMark(0, 0);
        game.initializeBoard();
        char[][] board = game.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals('-', board[i][j]);
            }
        }
    }

    @Test
    public void testCheckWinHorizontal() {
        TicTacToe game = new TicTacToe();
        game.placeMark(0, 0);
        game.placeMark(0, 1);
        game.placeMark(0, 2);
        assertTrue(game.checkForWin());
    }
}
















           



