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
    location.markHit();
    assertTrue(location.checkHit() == true);
  }

  @Test
  void checkMiss() {
  }

  @Test
  void isUnguessed() {
  }

  @Test
  void markHit() {
  }

  @Test
  void markMiss() {
  }

  @Test
  void hasShip() {
  }

  @Test
  void setShip() {
  }


  @Test
  void getLengthOfShip() {
  }

  @Test
  void setLengthOfShip() {
  }

  @Test
  void getDirectionOfShip() {
  }

  @Test
  void setDirectionOfShip() {
  }
}