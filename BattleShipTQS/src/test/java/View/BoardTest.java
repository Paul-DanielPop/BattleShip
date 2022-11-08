package View;
import Controller.Location;
import Model.Boat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

  @Test
  void testBoardConstructor(){
    Board board = new Board();

  }

  @Test
  void markHit(){
    Board b = new Board();
    assertTrue(b.getPoints()==0);
    Location loc = b.get(1,1);
    assertFalse(loc.getStatus()==loc.HIT);
    b.markHit(1,1);

    assertTrue(b.getPoints()==1);
    Location locHitted = b.get(1,1);
    assertTrue(locHitted.getStatus()==locHitted.HIT);
    Location locNoHit = b.get(1,2);
    assertFalse(locNoHit.getStatus()==locNoHit.HIT);
  }

  @Test
  void markMiss(){
    Board b = new Board();
    Location loc = b.get(1,1);
    assertFalse(loc.getStatus()==loc.MISSED);
    b.markMiss(1,1);

    Location locMissed = b.get(1,1);
    assertTrue(locMissed.getStatus()==locMissed.MISSED);
    Location locNoHit = b.get(1,2);
    assertFalse(locNoHit.getStatus()==locNoHit.MISSED);
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
    Location l1 = b.get(0,0);
    Location l2 = b.get(1,0);
    Location l3 = b.get(2,0);
    Location l4 = b.get(3,0);
    Location l5 = b.get(0,6);

    assertFalse(l1.hasShip());
    assertFalse(l2.hasShip());
    assertFalse(l3.hasShip());
    assertFalse(l4.hasShip());
    assertFalse(l5.hasShip());

    b.addBoat(boat);

    assertTrue(l1.hasShip());
    assertTrue(l2.hasShip());
    assertTrue(l3.hasShip());
    assertFalse(l4.hasShip());
    assertFalse(l5.hasShip());

  }

}