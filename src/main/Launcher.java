package main;

import controller.Controller;

/**
 * Created by Henrik on 02.10.2016.
 */
public class Launcher {
    public static void main(String[] args){
        //try{

            Controller instance = Controller.getInstance();
            instance.initialize();

            //Thread.sleep(3000);
            //System.out.println("updating value");
            //instance.changeModelAttributes(99,99);
        //}catch (Exception e){}
    }
}
