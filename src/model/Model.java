package model;

import java.util.Observable;

/**
 * Created by Henrik on 02.10.2016.
 */
public class Model extends Observable implements Runnable{

    private Player playerInstance;

    public Model(){
        playerInstance = Player.getInstance();
    }

    public void changePlayerPosition(int x,int y){
        System.out.println("Model: changing player's position");
        playerInstance.setX(x);
        playerInstance.setY(y);
        setChanged();
    }

    public int getPlayerPositionX(){
        return playerInstance.getX();
    }
    public int getPlayerPositionY(){
        return playerInstance.getY();
    }

    public void run(){
        while(true){
            try{
                Thread.sleep(50);
                if(this.hasChanged()){
                    notifyObservers(1);
                }

            }catch (InterruptedException e){
                System.out.println("model thread interrupted! " + e.getMessage());
            }
        }
    }
}
