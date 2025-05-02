package com.topdown.shooter;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    private int x, y;
    private int speed = 5;
    private boolean up, down, left, right;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update() {
        if (up) y -= speed;
        if (down) y += speed;
        if (left) x -= speed;
        if (right) x += speed;
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x - 15, y - 15, 30, 30);
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> up = true;
            case KeyEvent.VK_S -> down = true;
            case KeyEvent.VK_A -> left = true;
            case KeyEvent.VK_D -> right = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> up = false;
            case KeyEvent.VK_S -> down = false;
            case KeyEvent.VK_A -> left = false;
            case KeyEvent.VK_D -> right = false;
        }
    }

    public int getX() { return x; }
    public int getY() { return y; }
}
