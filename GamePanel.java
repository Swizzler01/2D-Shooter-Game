package com.topdown.shooter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private Player player;
    private ArrayList<Bullet> bullets;

    public GamePanel() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        player = new Player(400, 300);
        bullets = new ArrayList<>();

        timer = new Timer(16, this); // ~60 FPS
    }

    public void startGame() {
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);

        for (Bullet b : bullets) {
            b.draw(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();

        for (Bullet b : bullets) {
            b.update();
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        player.keyPressed(e);
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            bullets.add(new Bullet(player.getX(), player.getY()));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        player.keyReleased(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
