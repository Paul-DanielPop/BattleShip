package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoatTest {

  @Test
  void testBoatConstructor() {
    Boat barco1 = new Boat(3);

    assertTrue(barco1.getHundido() == false);
    assertFalse(barco1.getHundido() == true);
    assertTrue(barco1.getLength() == 3);
    assertTrue(barco1.getCoordX() == -1);
    assertTrue(barco1.getCoordY() == -1);
  }

  @Test
  void setLocation(){
    Boat boat = new Boat(3);

    assertTrue(boat.getCoordX() == -1);
    assertTrue(boat.getCoordY() == -1);

    boat.setLocation(2,4);

    assertTrue(boat.getCoordX() == 2);
    assertTrue(boat.getCoordY() == 4);
  }

  @Test
  void isLocationSet(){
    Boat boat = new Boat(3);
    assertTrue(boat.getCoordX() == -1);
    assertTrue(boat.getCoordY() == -1);
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