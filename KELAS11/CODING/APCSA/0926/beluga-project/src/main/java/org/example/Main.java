package org.example;

import processing.core.PApplet;

public class Main extends PApplet {
    private Sprite sushi;
    private Sprite alex;

    public static void main(String[] args) {
        PApplet.main(Main.class.getName());
    }

    @Override
    public void settings() {
        size(600, 600);
    }

    @Override
    public void setup() {
        background(255);

        sushi = new Sprite(this, "sushi", 2, "img/beluga.png");
        alex  = new Sprite(this, "alex",  5, "img/spinning_cat.gif");

        alex.moveTo(200, 200);
    }

    @Override
    public void draw() {
        background(255);
        sushi.show();
        alex.show();
    }
}
