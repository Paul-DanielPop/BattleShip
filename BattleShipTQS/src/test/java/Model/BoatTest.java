package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoatTest {

  @Test
  void testBoat() {
    Boat barco1 = new Boat(3, 'L');

    assertTrue(barco1.getVertical() == true);
    assertTrue(barco1.getHundido() == false);
    assertFalse(barco1.getHundido() == true);
    assertTrue(barco1.getLength() == 3);
    assertTrue(barco1.getIdentificador() == 'L');
  }

  @Test
  void setCoordY() {
  }

  @Test
  void getVertical() {
  }

  @Test
  void getHundido() {
  }

  @Test
  void getLength() {
  }

  @Test
  void getIdentificador() {
  }
}