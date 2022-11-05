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
  void getHundido() {
  }

  @Test
  void getLength() {
  }

  void setLocation(){

  }

}