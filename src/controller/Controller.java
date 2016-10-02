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

    private Properties props;
    private final View view;
    private final Model model;
    private boolean isInitialized = false;

    private Thread modelThread;

    private Controller() {
        loadProperties();

        view = new View(Integer.valueOf(props.getProperty("window.height")),
                Integer.valueOf(props.getProperty("window.width")),
                props.getProperty("project.title"));
        model = new Model();
        modelThread = new Thread(model);
    }

    private void loadProperties(){
        try{
            props = new Properties();
            FileInputStream s = new FileInputStream("res/settings.txt");
            props.load(s);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Controller getInstance() {
        return instance;
    }

    public void initialize() {
        model.addObserver(view);

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

    public int getPlayerPositionX(){
        return model.getPlayerPositionX();
    }

    public int getPlayerPositionY(){
        return model.getPlayerPositionY();
    }

}
