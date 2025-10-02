class Sprite {
  public String name;
  public Integer age;
  public PImage img;
  public Integer x = 0;
  public Integer y = 0;
  public Integer l = 100;
  public Integer w = 100;
  public Integer speed = 10;

  Sprite(String n, Integer a, String pic) {
    name = n;
    age = a;
    img = loadImage(pic);
  }

  public void say() {
    println("Hello, my name is " + name);
  }

  public void show() {
    image(img, x, y, l, w);
  }
  
// Teleport
  public void moveTo(Integer newX, Integer newY)
  {
    x = newX;
    y = newY;
  }
// Moving
  public void moveBy(Integer dx, Integer dy)
  {
    x += dx;
    y += dy;
  }
}
