package Model;

public class Boat {
  private boolean vertical =  true;
  private boolean hundido = false;
  private int length;
  private int coordX;
  private int coordY;
  private char identificador;

  public Boat(int length, char id) {
    this.length = length;
    this.identificador = id;
  }

  public void setCoordY() {

  }

  public boolean getVertical() {
    return vertical;
  }

  public boolean getHundido() {
    return hundido;
  }

  public int getLength() {
    return length;
  }

  public char getIdentificador() {
    return identificador;
  }

}