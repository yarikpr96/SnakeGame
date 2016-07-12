package ixn.snakegame;

import ixn.snakegame.ixn.snakegame.objects.Apple;
import ixn.snakegame.ixn.snakegame.objects.Snake;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;


/**
 * Created by Ярослав on 02.04.2016.
 */
public class SnakeGame extends JPanel implements ActionListener {
    public static final int SCALE = 33;
    public static final int WIGHT = 41;
    public static final int HEIGHT = 21;
    public static final int SPEED = 7;

    Apple a = new Apple((int) (Math.random() * WIGHT), (int) (Math.random() * HEIGHT));
    Snake s = new Snake(10, 10, 9, 10);
    Timer t = new Timer(1000 / SPEED, this);

    public SnakeGame() {
        t.start();
        addKeyListener(new Keydoard());
        setFocusable(true);
    }

    public void paint(Graphics g) {


        g.setColor(Color.blue);
        g.fillRect(0, 0, WIGHT * SCALE, HEIGHT * SCALE);
        g.setColor(Color.BLACK);

        for (int xx = 0; xx <= WIGHT * SCALE; xx += SCALE) {
            g.drawLine(xx, 0, xx, HEIGHT * SCALE);
        }
        for (int yy = 0; yy <= HEIGHT * SCALE; yy += SCALE) {
            g.drawLine(0, yy, WIGHT * SCALE, yy);
        }
        for (int d = 0; d < s.length; d++) {
            g.setColor(Color.YELLOW);
            g.fillRect(s.snakeX[d] * SCALE + 1, s.snakeY[d] * SCALE + 1, SCALE - 1, SCALE - 1);
        }
        g.setColor(Color.MAGENTA);
        g.fillRect(a.posX*SCALE+1,a.posY*SCALE+1,SCALE-1,SCALE-1);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setSize(WIGHT * SCALE + 7, HEIGHT * SCALE + 30);
        f.setLocationRelativeTo(null);
        f.add(new SnakeGame());
        f.setVisible(true);


    }


    public void actionPerformed(ActionEvent arg0) {
        s.move();
        if((s.snakeX[0]==a.posX)&(s.snakeY[0]==a.posY)){
            a.setRandomPosition();
            s.length++;
        }
        for(int k =1;k< s.length; k++){
            if((s.snakeX[k]==a.posX)&(s.snakeY[k]==a.posY)) {
                a.setRandomPosition();
                s.length++;
            }
        }

        repaint();
    }

    private class Keydoard extends KeyAdapter {
        public void keyPressed(KeyEvent kEvt) {
            int key = kEvt.getKeyCode();

            if ((key == KeyEvent.VK_RIGHT) & s.direction != 2) s.direction = 0;
            if ((key == KeyEvent.VK_DOWN) & s.direction != 3) s.direction = 1;
            if ((key == KeyEvent.VK_LEFT) & s.direction != 0) s.direction = 2;
            if ((key == KeyEvent.VK_UP) & s.direction != 1) s.direction = 3;
        }
    }


}
