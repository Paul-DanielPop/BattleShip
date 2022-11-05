package Model;

public class Boat {
  public static final int UNSET = -1;
  public static final int HORIZONTAL = 0;
  public static final int VERTICAL = 1;
  private boolean hundido = false;
  private int length;
  private int coordX;
  private int coordY;
  private int direction;

  public Boat(int length) {
    this.length = length;
    this.coordX = UNSET;
    this.coordY = UNSET;
    this.direction = UNSET;
  }

  public void setLocation(int x, int y){
    this.coordX = x;
    this.coordY = y;
  }

  public void setDirection(int dir){
    this.direction = dir;
  }

  public boolean isLocationSet(){
    if (coordX != UNSET && coordY != UNSET)
      return true;
    else
      return false;
  }

  public boolean isDirectionSet(){
    if(direction != UNSET)
      return true;
    else
      return false;
  }

  public boolean getHundido() {
    return hundido;
  }

  public int getLength() {
    return length;
  }

  public int getCoordX(){
    return coordX;
  }

  public int getCoordY() {
    return coordY;
  }
}