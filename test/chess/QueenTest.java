package chess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * The type Queen test.
 */
public class QueenTest {

  /**
   * The Queen.
   */
  Queen queen;

  /**
   * Sets up.
   */
  @Before
  public void setUp() {
    queen = new Queen(2, 3, Color.WHITE);
    // Test valid black color
    Queen testBlack = new Queen(3, 5, Color.BLACK);
  }

  /**
   * Test bad set up.
   */
  @Test
  public void testBadSetUp() {
    try {
      new Queen(-1, 1, Color.WHITE);
      fail("Illegal row or column.");
    } catch (IllegalArgumentException e) {
    }
    try {
      new Queen(9, 1, Color.BLACK);
      fail("Illegal row or column.");
    } catch (IllegalArgumentException e) {
    }
    try {
      new Queen(9, -1, Color.WHITE);
      fail("Illegal row or column.");
    } catch (IllegalArgumentException e) {
    }
  }

  /**
   * Test outside board.
   */
  @Test
  public void outsideBoard() {
    assertFalse(queen.outsideBoard(5, 5));
    assertTrue(queen.outsideBoard(-1, 5));
    assertTrue(queen.outsideBoard(10, 5));
  }

  /**
   * Gets row.
   */
  @Test
  public void getRow() {
    assertEquals(2, queen.getRow());
  }

  /**
   * Gets column.
   */
  @Test
  public void getColumn() {
    assertEquals(3, queen.getColumn());
  }

  /**
   * Gets color.
   */
  @Test
  public void getColor() {
    assertEquals(Color.WHITE, queen.getColor());
    assertEquals(Color.BLACK, new Queen(1, 1, Color.BLACK).getColor());
  }

  /**
   * Can move.
   */
  @Test
  public void canMove() {
    // out of board
    assertFalse(queen.canMove(9, 9));
    // other position in board
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (i == 2 && j == 3) {
          assertFalse(queen.canMove(i, j));
        } else if (i == 2 || j == 3) {
          assertTrue(queen.canMove(i, j));
        } else if (Math.abs(i - 2) == Math.abs(j - 3)) {
          assertTrue(queen.canMove(i, j));
        } else {
          assertFalse(queen.canMove(i, j));
        }
      }
    }
  }

  /**
   * Test canKill.
   */
  @Test
  public void canKill() {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        // same color
        assertFalse(queen.canKill(new King(i, j, Color.WHITE)));
        if (i == 2 && j == 3) {
          assertFalse(queen.canKill(new King(i, j, Color.BLACK)));
        } else if (i == 2 || j == 3) {
          assertTrue(queen.canKill(new King(i, j, Color.BLACK)));
        } else if (Math.abs(i - 2) == Math.abs(j - 3)) {
          assertTrue(queen.canKill(new King(i, j, Color.BLACK)));
        } else {
          assertFalse(queen.canKill(new King(i, j, Color.BLACK)));
        }
      }
    }
  }
}