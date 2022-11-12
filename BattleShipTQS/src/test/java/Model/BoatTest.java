package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoatTest {

  @Test
  void testBoatConstructor() {
    Boat barco1 = new Boat(3);

    assertEquals(3, barco1.getLength());
    assertEquals(-1, barco1.getCoordX());
    assertEquals(-1, barco1.getCoordY());
  }

  @Test
  void setLocation(){
    Boat boat = new Boat(3);

    assertEquals(-1, boat.getCoordX());
    assertEquals(-1, boat.getCoordY());

    boat.setLocation(2,4);

    assertEquals(2, boat.getCoordX());
    assertEquals(4, boat.getCoordY());
  }

  @Test
  void isLocationSet(){
    Boat boat = new Boat(3);
    assertEquals(-1, boat.getCoordX());
    assertEquals(-1, boat.getCoordY());
    assertFalse(boat.isLocationSet());

    boat.setLocation(2,4);

    assertTrue(boat.isLocationSet());

  }

  @Test
  void isDirectionSet(){
    Boat boat = new Boat(3);
    assertFalse(boat.isDirectionSet());
    boat.setDirection(Boat.HORIZONTAL);
    assertTrue(boat.isDirectionSet());

  }

}