package chess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * The type King test.
 */
public class KingTest {

  /**
   * The King.
   */
  King king;

  /**
   * Sets up.
   */
  @Before
  public void setUp() {
    king = new King(2, 3, Color.WHITE);
    King testBlack = new King(3, 5, Color.BLACK);
  }

  /**
   * Test bad set up.
   */
  @Test
  public void testBadSetUp() {
    try {
      new King(-1, 1, Color.WHITE);
      fail("Illegal row or column.");
    } catch (IllegalArgumentException e) {
    }
    try {
      new King(9, 1, Color.BLACK);
      fail("Illegal row or column.");
    } catch (IllegalArgumentException e) {
    }
    try {
      new King(9, -1, Color.WHITE);
      fail("Illegal row or column.");
    } catch (IllegalArgumentException e) {
    }
  }

  /**
   * Test outside board.
   */
  @Test
  public void outsideBoard() {
    assertFalse(king.outsideBoard(5, 5));
    assertTrue(king.outsideBoard(-1, 5));
    assertTrue(king.outsideBoard(10, 5));
  }

  /**
   * Gets row.
   */
  @Test
  public void getRow() {
    assertEquals(2, king.getRow());
  }

  /**
   * Gets column.
   */
  @Test
  public void getColumn() {
    assertEquals(3, king.getColumn());
  }

  /**
   * Gets color.
   */
  @Test
  public void getColor() {
    assertEquals(Color.WHITE, king.getColor());
    assertEquals(Color.BLACK, new King(1, 1, Color.BLACK).getColor());
  }

  /**
   * Test canMove.
   */
  @Test
  public void canMove() {
    // out of board
    assertFalse(king.canMove(9, 9));
    // other position in board
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (i == 2 && j == 3) {
          assertFalse(king.canMove(i, j));
        } else if (Math.abs(i - 2) <= 1 && Math.abs(j - 3) <= 1) {
          assertTrue(king.canMove(i, j));
        } else {
          assertFalse(king.canMove(i, j));
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
        assertFalse(king.canKill(new King(i, j, Color.WHITE)));
        if (i == 2 && j == 3) {
          assertFalse(king.canKill(new King(i, j, Color.BLACK)));
        } else if (Math.abs(i - 2) <= 1 && Math.abs(j - 3) <= 1) {
          assertTrue(king.canKill(new King(i, j, Color.BLACK)));
        } else {
          assertFalse(king.canKill(new King(i, j, Color.BLACK)));
        }
      }
    }
  }
}