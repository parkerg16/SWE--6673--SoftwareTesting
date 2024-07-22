package src.test.java.com.example;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import src.main.java.com.example.TicTacToe;

public class TicTacToeTest {
    private TicTacToe game;
    
@Before
    public void setUp(){
        game = new TicTacToe (); 
    }

@Test
    public void testInitialBoardState() {
        char[][] board = game.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals('-', board[i][j]);
            }
        }
    }
@Test 
    public void testPlayerMove(){
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
        game.placeMark (0,0);
        game.placeMark(0, 1);
        game.placeMark(0, 2);
        assertTrue(game.checkForWin());
    }

    @Test
    public void testWinningConditionColumn() {
        game.placeMark(0, 0);
        game.placeMark(1, 0);
        game.placeMark(2, 0);
        assertTrue(game.checkForWin());
    }

    @Test
    public void testWinningConditionDiagonal() {
        game.placeMark(0, 0);
        game.placeMark(1, 1);
        game.placeMark(2, 2);
        assertTrue(game.checkForWin());
    }

    @Test
    public void testDrawCondition() {
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
        game.placeMark(0, 0);
        assertEquals('O', game.getCurrentPlayer());
        game.placeMark(1, 1);
        assertEquals('X', game.getCurrentPlayer());
    }

    @Test
    public void testWinningConditionAntiDiagonal() {
        game.placeMark(0, 2);
        game.placeMark(1, 1);
        game.placeMark(2, 0);
        assertTrue(game.checkForWin());
    }

    @Test
    public void testInvalidMoveOutOfBounds() {
        assertFalse(game.placeMark(3, 3));
    }

    @Test
    public void testWinningConditionNotMet() {
        game.placeMark(0, 0);
        game.placeMark(0, 1);
        assertFalse(game.checkForWin());
    }

    @Test
    public void testGameNotOverInitially() {
        assertFalse(game.isGameOver());
    }

    @Test
    public void testGameOverAfterWin() {
        game.placeMark(0, 0);
        game.placeMark(0, 1);
        game.placeMark(0, 2);
        assertTrue(game.isGameOver());
    }

    @Test
    public void testGameOverAfterDraw() {
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
        game.placeMark(0, 0);
        assertFalse(game.placeMark(0, 0));
    }

    @Test
    public void testPlayerCannotMoveOutsideBoard() {
        assertFalse(game.placeMark(-1, 0));
        assertFalse(game.placeMark(0, -1));
        assertFalse(game.placeMark(3, 0));
        assertFalse(game.placeMark(0, 3));
    }

    @Test
    public void testPlayerCannotMoveAfterGameOver() {
        game.placeMark(0, 0);
        game.placeMark(0, 1);
        game.placeMark(0, 2);
        assertFalse(game.placeMark(1, 0));
    }

    @Test
    public void testSwitchPlayerAfterMove() {
        game.placeMark(0, 0);
        assertEquals('O', game.getCurrentPlayer());
        game.placeMark(1, 1);
        assertEquals('X', game.getCurrentPlayer());
    }

    @Test
    public void testGetCurrentPlayer() {
        assertEquals('X', game.getCurrentPlayer());
        game.placeMark(0, 0);
        assertEquals('O', game.getCurrentPlayer());
    }

    @Test
    public void testGameInitialization() {
        assertNotNull(game.getBoard());
        assertEquals('X', game.getCurrentPlayer());
    }

    @Test
    public void testGameOverAfterPlayerWins() {
        game.placeMark(0, 0);
        game.placeMark(0, 1);
        game.placeMark(0, 2);
        assertTrue(game.isGameOver());
    }

    @Test
    public void testBoardFullButNoWinner() {
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
        game.placeMark(0, 0);
        assertEquals('X', game.getBoard()[0][0]);
    }

    @Test
    public void testGameNotOverAfterReset() {
        game.placeMark(0, 0);
        game.initializeBoard();
        assertFalse(game.isGameOver());
    }

    @Test
    public void testGetBoardAfterReset() {
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
        game.placeMark(0, 0);
        game.placeMark(0, 1);
        game.placeMark(0, 2);
        assertTrue(game.checkForWin());
    }

    @Test
    public void testNoWinConditionWhenBoardEmpty() {
        assertFalse(game.checkForWin());
    }

    @Test
    public void testBoardUpdatesAfterSeveralMoves() {
        game.placeMark(0, 0);
        game.placeMark(0, 1);
        game.placeMark(1, 0);
        game.placeMark(1, 1);
        assertEquals('X', game.getBoard()[0][0]);
        assertEquals('O', game.getBoard()[0][1]);
        assertEquals('X', game.getBoard()[1][0]);
        assertEquals('O', game.getBoard()[1][1]);
    }

    @Test
    public void testBoardNotFull() {
        game.placeMark(0, 0);
        game.placeMark(0, 1);
        game.placeMark(0, 2);
        game.placeMark(1, 0);
        game.placeMark(1, 1);
        assertFalse(game.isDraw());
    }
}














           



