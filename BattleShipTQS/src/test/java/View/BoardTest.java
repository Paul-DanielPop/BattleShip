package View;
import Controller.Location;
import Model.Boat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

  @Test
  void testBoardConstructor(){
    Board board = new Board();

    for (int row = 0; row < board.getNumRows(); row++){
      for (int col = 0; col < board.getNumCols(); col++){
        assertEquals(0, board.getStatus(row, col));
      }
    }

  }

  @Test
  void markHit(){
    Board b = new Board();
    assertEquals(0, b.getPoints());
    Location loc = b.get(1,1);
    assertNotEquals(Location.HIT, loc.getStatus());
    b.markHit(1,1);

    assertEquals(1, b.getPoints());
    Location locHitted = b.get(1,1);
    assertEquals(Location.HIT, locHitted.getStatus());
    Location locNoHit = b.get(1,2);
    assertNotEquals(Location.HIT, locNoHit.getStatus());
  }

  @Test
  void markMiss(){
    Board b = new Board();
    Location loc = b.get(1,1);
    assertNotEquals(Location.MISSED, loc.getStatus());
    b.markMiss(1,1);

    Location locMissed = b.get(1,1);
    assertEquals(Location.MISSED, locMissed.getStatus());
    Location locNoHit = b.get(1,2);
    assertNotEquals(Location.MISSED, locNoHit.getStatus());
  }

  @Test
  void alreadyGuessed(){
    Board b = new Board();
    assertFalse(b.alreadyGuessed(1,1));

    b.markHit(1,1);
    assertTrue(b.alreadyGuessed(1,1));
  }

  @Test
  void hasLost(){
    Board b = new Board();
    assertFalse(b.hasLost());
    for (int i=0;i<9;i++)
      b.markHit(i,0);
    for (int i=0;i<9;i++)
      b.markHit(i,5);

    assertTrue(b.hasLost());
  }


  @Test
  void addBoat(){
    Board b = new Board();
    Boat boat = new Boat(3);
    boat.setDirection(Boat.VERTICAL);
    boat.setLocation(0,0);

    assertFalse(b.hasShip(0,0));
    assertFalse(b.hasShip(1,0));
    assertFalse(b.hasShip(2,0));
    assertFalse(b.hasShip(3,0));
    assertFalse(b.hasShip(0,6));

    b.addBoat(boat);

    assertTrue(b.hasShip(0,0));
    assertTrue(b.hasShip(1,0));
    assertTrue(b.hasShip(2,0));
    assertFalse(b.hasShip(3,0));
    assertFalse(b.hasShip(0,6));


    Board b1 = new Board();
    Boat boat1 = new Boat(4);
    boat1.setDirection(Boat.HORIZONTAL);
    boat1.setLocation(6,9);

    assertFalse(b1.hasShip(9,6));
    assertFalse(b1.hasShip(9,7));
    assertFalse(b1.hasShip(9,8));
    assertFalse(b1.hasShip(9,9));
    assertFalse(b1.hasShip(9,5));

    b1.addBoat(boat1);

    assertTrue(b1.hasShip(9,6));
    assertTrue(b1.hasShip(9,7));
    assertTrue(b1.hasShip(9,8));
    assertTrue(b1.hasShip(9,9));
    assertFalse(b1.hasShip(9,5));
  }

  @Test
  void switchIntToChar(){
    Board b = new Board();

    char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

    for (int i = 0; i < 10; i++){
      char c = b.switchIntToChar(i);
      assertEquals(c, letters[i]);
    }
    char c = b.switchIntToChar(12);
    assertEquals('Z', c);
  }

}