package model;

/**
 * Created by Henrik on 02.10.2016.
 */
public class Player {
    private static Player instance = new Player();

    private int x;
    private int y;

    public static Player getInstance() {
        return instance;
    }

    private Player() {
    }

    public void setX(int x){this.x=x;}
    public void setY(int y){this.y=y;}

    public int getX(){return x;}
    public int getY(){return y;}

}
