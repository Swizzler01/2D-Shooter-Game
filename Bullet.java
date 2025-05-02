package com.topdown.shooter;
import java.awt.*;

public class Bullet {
    private int x, y;
    private int speed = 10;

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update() {
        y -= speed;
    }

    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(x - 5, y - 10, 10, 10);
    }
}
