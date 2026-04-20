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
  
  if (keyPressed) {
    if (key == 'a' || key == 'A') {
        alex.moveBy(-alex.speed, 0);
    }
    if (key == 's' || key == 'S') {
        alex.moveBy(0, alex.speed);
    }
    if (key == 'd' || key == 'D') {
        alex.moveBy(alex.speed, 0);
    }
    if (key == 'w' || key == 'W') {
        alex.moveBy(0, -alex.speed);
    }
  } 
}
