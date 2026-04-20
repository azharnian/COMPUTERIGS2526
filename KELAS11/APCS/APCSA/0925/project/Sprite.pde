class Sprite {
  public String name;
  public Integer age;
  public PImage img;
  public Integer x = 0;
  public Integer y = 0;
  public Integer l = 100;
  public Integer w = 100;
  public Integer speed = 10;
  
  public Integer padding = 20;

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
    
    if ( (dx < 0 && x > padding)  || (dx > 0 && x < (width-padding-w)))
    {
      x += dx;
    }
    
    if ( (dy < 0 && y > padding) || (dy > 0 && y < (height-padding-l)))
    {
      y += dy;
    }
    
  }
}
