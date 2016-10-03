package view;

import controller.Controller;

import java.io.FileInputStream;
import java.util.Observable;
import java.util.Observer;
import java.util.Properties;

/**
 * Created by Henrik on 03.10.2016.
 */
public class ViewManager  implements Observer {
    private static ViewManager ourInstance = new ViewManager();

    public static ViewManager getInstance() {
        return ourInstance;
    }

    private String propsLocation;
    private Properties props;
    private boolean initialized;
    private MenuWindow menu;
    private InGameWindow ingame;

    private ViewManager(){
        initialized = false;
    }

    public void initialize(String propsLocation) {
        this.propsLocation = propsLocation;
        loadProperties();
        menu = new MenuWindow(Integer.valueOf(props.getProperty("menu.height")),
                Integer.valueOf(props.getProperty("menu.width")),
                props.getProperty("project.title"));
        menu.activate();
        initialized = true;
    }

    public boolean isInitialized(){
        return initialized;
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
    public void startGameWindow(){
        menu.deActivate();
        ingame = new InGameWindow(propsLocation);
        ingame.activate();
    }

    public void update(Observable o, Object arg){
        System.out.println("received model update.");
        if((int)arg == 1){
            System.out.println("new Player's position: " + Controller.getInstance().getPlayerPositionX() + "," + Controller.getInstance().getPlayerPositionY());
        }
    }
}
