Sprite sushi;
Sprite alex;

void setup() {
  size(800, 600);

  sushi = new Sprite("sushi", 2, "img/beluga.png");
  alex = new Sprite("alex", 5, "img/spinning_cat.gif");
  alex.moveTo(200, 200);
}

void draw() {
  background(255);
  sushi.show();
  alex.show();
}

public class Sprite {
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
  
  public void moveTo(Integer left, Integer down)
  {
    x += left;
    y += down;
  }
}
