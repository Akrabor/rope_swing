package main;

import controller.Controller;
import view.ViewManager;

/**
 * Created by Henrik on 02.10.2016.
 */
public class Launcher {
    public static void main(String[] args){
        Controller instance = Controller.getInstance();
        instance.initialize();
    }
}
