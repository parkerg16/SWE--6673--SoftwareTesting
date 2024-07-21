import org.junit.Test;
import static org.junit.Assert.*;

public class TicTacToeTest {
    private class TicTacToe game;

    @Before
    public void setUp(){
        game = new TicTacToe (); 
    }
}
@Test
    public void testInitialBoardState() {
        String[][] board = game.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(String.valueOf(3 * i + j + 1), board[i][j]);
            }
        }
    }
@Test 
public void testPlayerMove(){
    game.makeMove(0,0,"X");
    assertEquals('X', game.getBoard ()[O][0]);
}
@Test
public void testInvalidMove() {
    game.makeMove(0, 0, 'X');
    assertFalse(game.makeMove(0, 0, 'O'));
}

@Test
public void testWinningConditionRow() {
    game.makeMove(0, 0, 'X');
    game.makeMove(0, 1, 'X');
    game.makeMove(0, 2, 'X');
    assertTrue(game.checkWin('X'));
}

@Test
public void testWinningConditionColumn() {
    game.makeMove(0, 0, 'X');
    game.makeMove(1, 0, 'X');
    game.makeMove(2, 0, 'X');
    assertTrue(game.checkWin('X'));
}

@Test
public void testWinningConditionDiagonal() {
    game.makeMove(0, 0, 'X');
    game.makeMove(1, 1, 'X');
    game.makeMove(2, 2, 'X');
    assertTrue(game.checkWin('X'));
}

@Test
public void testDrawCondition() {
    game.makeMove(0, 0, 'X');
    game.makeMove(0, 1, 'O');
    game.makeMove(0, 2, 'X');
    game.makeMove(1, 0, 'O');
    game.makeMove(1, 1, 'X');
    game.makeMove(1, 2, 'O');
    game.makeMove(2, 0, 'O');
    game.makeMove(2, 1, 'X');
    game.makeMove(2, 2, 'O');
    assertTrue(game.isDraw());
}

@Test
public void testGameReset() {
    game.makeMove(0, 0, 'X');
    game.resetGame();
    String[][] board = game.getBoard();
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            assertEquals(String.valueOf(3 * i + j + 1), board[i][j]);
        }
    }
}

@Test
public void testPlayerSwitching() {
    game.makeMove(0, 0, 'X');
    assertEquals('O', game.getCurrentPlayer());
    game.makeMove(1, 1, 'O');
    assertEquals('X', game.getCurrentPlayer());
}
@Test
       public void testWinningConditionAntiDiagonal() {
           game.makeMove(0, 2, 'X');
           game.makeMove(1, 1, 'X');
           game.makeMove(2, 0, 'X');
           assertTrue(game.checkWin('X'));
       }

       @Test
       public void testInvalidMoveOutOfBounds() {
           assertFalse(game.makeMove(3, 3, 'X'));
       }

       @Test
       public void testWinningConditionNotMet() {
           game.makeMove(0, 0, 'X');
           game.makeMove(0, 1, 'X');
           assertFalse(game.checkWin('X'));
       }

       @Test
       public void testGameNotOverInitially() {
           assertFalse(game.isGameOver());
       }

       @Test
       public void testGameOverAfterWin() {
           game.makeMove(0, 0, 'X');
           game.makeMove(0, 1, 'X');
           game.makeMove(0, 2, 'X');
           assertTrue(game.isGameOver());
       }

       @Test
       public void testGameOverAfterDraw() {
           game.makeMove(0, 0, 'X');
           game.makeMove(0, 1, 'O');
           game.makeMove(0, 2, 'X');
           game.makeMove(1, 0, 'O');
           game.makeMove(1, 1, 'X');
           game.makeMove(1, 2, 'O');
           game.makeMove(2, 0, 'O');
           game.makeMove(2, 1, 'X');
           game.makeMove(2, 2, 'O');
           assertTrue(game.isGameOver());
       }

       @Test
       public void testPlayerCannotOverwriteMove() {
           game.makeMove(0, 0, 'X');
           assertFalse(game.makeMove(0, 0, 'O'));
       }
   
       @Test
       public void testPlayerCannotMoveOutsideBoard() {
           assertFalse(game.makeMove(-1, 0, 'X'));
           assertFalse(game.makeMove(0, -1, 'X'));
           assertFalse(game.makeMove(3, 0, 'X'));
           assertFalse(game.makeMove(0, 3, 'X'));
       }
   
       @Test
       public void testPlayerCannotMoveAfterGameOver() {
           game.makeMove(0, 0, 'X');
           game.makeMove(0, 1, 'X');
           game.makeMove(0, 2, 'X');
           assertFalse(game.makeMove(1, 0, 'O'));
       }
   
       @Test
       public void testSwitchPlayerAfterMove() {
           game.makeMove(0, 0, 'X');
           assertEquals('O', game.getCurrentPlayer());
           game.makeMove(1, 1, 'O');
           assertEquals('X', game.getCurrentPlayer());
       }
   
       @Test
       public void testGetCurrentPlayer() {
           assertEquals('X', game.getCurrentPlayer());
           game.makeMove(0, 0, 'X');
           assertEquals('O', game.getCurrentPlayer());
       }
   
       @Test
       public void testGameInitialization() {
           assertNotNull(game.getBoard());
           assertEquals('X', game.getCurrentPlayer());
       }
   
       @Test
       public void testGameOverAfterPlayerWins() {
           game.makeMove(0, 0, 'X');
           game.makeMove(0, 1, 'X');
           game.makeMove(0, 2, 'X');
           assertTrue(game.isGameOver());
       }
   
       @Test
       public void testBoardFullButNoWinner() {
           game.makeMove(0, 0, 'X');
           game.makeMove(0, 1, 'O');
           game.makeMove(0, 2, 'X');
           game.makeMove(1, 0, 'X');
           game.makeMove(1, 1, 'X');
           game.makeMove(1, 2, 'O');
           game.makeMove(2, 0, 'O');
           game.makeMove(2, 1, 'X');
           game.makeMove(2, 2, 'O');
           assertTrue(game.isDraw());
           assertTrue(game.isGameOver());
       }
   
       @Test
       public void testMoveUpdatesBoardCorrectly() {
           game.makeMove(0, 0, 'X');
           assertEquals('X', game.getBoard()[0][0]);
       }
   
       @Test
       public void testGameNotOverAfterReset() {
           game.makeMove(0, 0, 'X');
           game.resetGame();
           assertFalse(game.isGameOver());
       }
   
       @Test
       public void testGetBoardAfterReset() {
           game.makeMove(0, 0, 'X');
           game.resetGame();
           String[][] board = game.getBoard();
           for (int i = 0; i < 3; i++) {
               for (int j = 0; j < 3; j++) {
                   assertEquals(String.valueOf(3 * i + j + 1), board[i][j]);
               }
           }
       }
   
       @Test
       public void testCheckWinHorizontal() {
           game.makeMove(1, 0, 'X');
           game.makeMove(1, 1, 'X');
           game.makeMove(1, 2, 'X');
           assertTrue(game.checkWin('X'));
       }
   
       @Test
       public void testCheckWinVertical() {
           game.makeMove(0, 1, 'X');
           game.makeMove(1, 1, 'X');
           game.makeMove(2, 1, 'X');
           assertTrue(game.checkWin('X'));
       }
   
       @Test
       public void testCheckWinDiagonal1() {
           game.makeMove(0, 0, 'X');
           game.makeMove(1, 1, 'X');
           game.makeMove(2, 2, 'X');
           assertTrue(game) }
           



