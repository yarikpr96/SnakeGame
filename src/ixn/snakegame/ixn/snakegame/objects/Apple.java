package ixn.snakegame.ixn.snakegame.objects;

import ixn.snakegame.SnakeGame;

/**
 * Created by Ярослав on 02.04.2016.
 */
public class Apple {
    SnakeGame main;

    public int posX;
    public int posY;

    public Apple(int startX, int startY) {
        posX = startX;
        posY = startY;

    }

public void setRandomPosition(){
    posX = (int)(Math.random()*main.WIGHT);
    posY = (int)(Math.random()*main.HEIGHT);

}
}
