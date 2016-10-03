package controller;

import view.*;
import model.*;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by Henrik on 02.10.2016.
 */
public class Controller{
    private static Controller instance = new controller.Controller();

    private String propsLocation = "res/settings.txt";
    private Properties props;
    private final ViewManager viewManager;
    private final Model model;
    private boolean isInitialized = false;

    private Thread modelThread;

    private Controller() {
        loadProperties();

        viewManager = ViewManager.getInstance();

        viewManager.initialize(propsLocation);
        model = new Model();
        modelThread = new Thread(model);
    }

    private void loadProperties(){
        try{
            props = new Properties();
            FileInputStream s = new FileInputStream(propsLocation);
            props.load(s);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Controller getInstance() {
        return instance;
    }

    public void initialize() {
        model.addObserver(viewManager);

        modelThread.start();
        System.out.println("modelThread started");

        isInitialized = true;
    }

    public boolean isInitialized(){
        return isInitialized;
    }

    public void changePlayerPosition (int x, int y){
        model.changePlayerPosition(x,y);
    }

    public void startGame(){
        viewManager.startGameWindow();
    }

    public int getPlayerPositionX(){
        return model.getPlayerPositionX();
    }

    public int getPlayerPositionY(){
        return model.getPlayerPositionY();
    }

}
