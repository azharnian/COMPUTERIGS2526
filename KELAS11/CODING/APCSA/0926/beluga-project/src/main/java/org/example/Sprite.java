package org.example;

import processing.core.PApplet;
import processing.core.PImage;

public class Sprite {
    private final PApplet app;
    public String name;
    public int age;
    public PImage img;
    public int x = 0;
    public int y = 0;
    public int w = 100;   // width
    public int h = 100;   // height
    public int speed = 10;

    public Sprite(PApplet app, String n, int a, String picPath) {
        this.app  = app;
        this.name = n;
        this.age  = a;

        // Load dari resources (src/main/resources). Pastikan path benar.
        this.img = app.loadImage(picPath);

        if (this.img == null) {
            app.println("Gagal load image: " + picPath +
                    " — pastikan file ada di src/main/resources/" + picPath);
        }
    }

    public void say() {
        app.println("Hello, my name is " + name);
    }

    public void show() {
        if (img != null) {
            app.stroke(0);
            app.fill(255);
            app.image(img, x, y, w, h);
        }
    }

    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveBy(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
}
