package Controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {
  private Location location = null;

  @Test
  void testLocationConstructor(){
    location = new Location();

    assertTrue(location.getStatus() == 0);
    assertTrue(location.hasShip() == false);
    assertTrue(location.getLengthOfShip() == -1);
    assertTrue(location.getDirectionOfShip() == -1);
  }
  @Test
  void checkHit() {
    location = new Location();

    assertTrue(location.checkHit() == false);
    assertTrue(location.getStatus() == 0);
    location.markHit();
    assertTrue(location.checkHit() == true);
    assertTrue(location.getStatus() == 1);
    assertFalse(location.getStatus() != 1);
  }

  @Test
  void checkMiss() {
    location = new Location();

    assertTrue(location.checkMiss() == false);
    assertTrue(location.getStatus() == 0);
    location.markMiss();
    assertTrue(location.checkMiss() == true);
    assertTrue(location.getStatus() == 2);
    assertFalse(location.getStatus() != 2);
  }

  @Test
  void isUnguessed() {
    location = new Location();

    assertTrue(location.isUnguessed() == true);
    assertTrue(location.getStatus() == 0);
    location.markMiss();
    assertTrue(location.isUnguessed() == false);
    location.markHit();
    assertTrue(location.isUnguessed() == false);
    assertTrue(location.isUnguessed() == false);
  }


  @Test
  void hasShip() {
    location = new Location();

    assertTrue(location.hasShip() == false);
    location.setShip(true);
    assertTrue(location.hasShip() == true);
    location.setShip(false);
    assertTrue(location.hasShip() == false);
  }

}