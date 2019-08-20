public class Pixel {

  private int x;
  private int y;
  public Pixel(int x, int y) {
    assert(x >= 0);
    assert(y >= 0);
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

}
